package domain;

import static domain.ExceptionMessage.INVALID_NAME_LENGTH;
import static domain.ExceptionMessage.INVALID_TRIAL_COUNT;
import static domain.GameMessage.ASK_CAR_NAME;
import static domain.GameMessage.ASK_GAME_COUNT;
import static domain.GameMessage.RESULT;
import static domain.GameMessage.WINNER;
import static domain.RacingCar.POSITION_UNIT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import util.IOHandler;
import util.RandomNumberGenerator;

public class RacingGame {

    private static final int MIN_TRIAL_COUNT = 1;
    private static final int RANDOM_MIN_NUMBER = 0;
    private static final int RANDOM_MAX_NUMBER = 9;
    private static final int RANDOM_THRESHOLD = 4;
    private static final String DELIMITER = ",";
    private static IOHandler ioHandler;
    private static final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    private static final ArrayList<RacingCar> cars = new ArrayList<>();
    private static int trialCount;

    public RacingGame(IOHandler ioHandler) {
        RacingGame.ioHandler = ioHandler;
    }

    public void run() {
        generateCars();
        setTrialCount();

        ioHandler.println("\n" + RESULT.getMessage());
        while (trialCount-- > 0) {
            playOneRound();
        }

        printWinners();
    }

    void generateCars() {
        while (true) {
            try {
                List<String> carNames = askCarNames();
                List<String> validatedCarNames = validateCarNames(carNames);
                createCars(validatedCarNames);
                break;
            } catch (IllegalArgumentException e) {
                ioHandler.println(e.getMessage());
            }
        }
    }

    List<String> askCarNames() {
        ioHandler.println(ASK_CAR_NAME.getMessage());
        String carNamesInput = ioHandler.getStringInput();
        return Arrays.asList(carNamesInput.split(DELIMITER));
    }

    List<String> validateCarNames(List<String> carNames) {
        validateCarNameLengths(carNames);
        validateUniqueCarNames(carNames);
        return carNames;
    }

    void createCars(List<String> validCarNames) {
        for (String name : validCarNames) {
            cars.add(new RacingCar(name.trim()));
        }
    }

    void setTrialCount() {
        while (true) {
            try {
                ioHandler.println(ASK_GAME_COUNT.getMessage());
                trialCount = ioHandler.getIntInput();
                validateTrialCount(trialCount);
                break;
            } catch (IllegalArgumentException e) {
                ioHandler.println(e.getMessage());
                setTrialCount();
            }
        }
    }

    void playOneRound() {
        for (RacingCar car : cars) {
            if (isMoveForward()) {
                car.moveForward();
            }
            ioHandler.println(car.getName() + " : " + getPositionUnits(car.getPosition()));
        }
        ioHandler.println("");
    }

    String getPositionUnits(int position) {
        return POSITION_UNIT.repeat(Math.max(0, position));
    }

    void printWinners() {
        int maxPosition = getMaxPosition();
        List<String> winners = getWinners(maxPosition);
        ioHandler.println(WINNER.getMessage() + String.join(DELIMITER + " ", winners));
    }

    int getMaxPosition() {
        return cars.stream()
            .mapToInt(RacingCar::getPosition)
            .max()
            .orElseThrow(() -> new IllegalArgumentException("최대 위치를 찾을 수 없습니다."));
    }

    List<String> getWinners(int maxPosition) {
        return cars.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .map(RacingCar::getName)
            .toList();
    }

    boolean isMoveForward() {
        return randomNumberGenerator.generate(RANDOM_MIN_NUMBER, RANDOM_MAX_NUMBER) >= RANDOM_THRESHOLD;
    }

    private void validateCarNameLengths(List<String> carNames) {
        for (String name : carNames) {
            if (name.trim().length() > RacingCar.MAX_NAME_LENGTH) {
                throw new IllegalArgumentException(INVALID_NAME_LENGTH.getMessage() + ": " + name);
            }
        }
    }

    private void validateUniqueCarNames(List<String> carNames) {
        Set<String> uniqueNames = new HashSet<>();
        for (String name : carNames) {
            String trimmedName = name.trim();
            if (!uniqueNames.add(trimmedName)) {
                throw new IllegalArgumentException(
                    ExceptionMessage.DUPLICATED_CAR_NAME.getMessage() + ": " + trimmedName);
            }
        }
    }

    private void validateTrialCount(int trialCount) {
        if (trialCount < MIN_TRIAL_COUNT) {
            throw new IllegalArgumentException(INVALID_TRIAL_COUNT.getMessage());
        }
    }

    public List<RacingCar> getCars() {
        return cars;
    }

    public int getTrialCount() {
        return trialCount;
    }
}
