package domain;

import static domain.ExceptionMessage.INVALID_NAME_LENGTH;
import static domain.GameMessage.ASK_CAR_NAME;
import static domain.GameMessage.ASK_GAME_COUNT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import util.IOHandler;

public class RacingGame {

    static final int MIN_TRIAL_COUNT = 1;
    static final String DELIMITER = ",";
    static final IOHandler ioHandler = new IOHandler();
    static final ArrayList<RacingCar> cars = new ArrayList<>();
    static int trialCount;

    public void run() {
        generateCars();
        trialCount = askTrialCount();
    }

    private void generateCars() {
        List<String> carNames = askCarNames();
        List<String> validatedCarNames = validateCarNames(carNames);
        createCars(validatedCarNames);
    }

    private List<String> askCarNames() {
        ioHandler.println(ASK_CAR_NAME.getMessage());
        String carNamesInput = ioHandler.getStringInput();
        return Arrays.asList(carNamesInput.split(DELIMITER));
    }

    private List<String> validateCarNames(List<String> carNames) {
        for (String name : carNames) {
            if (name.trim().length() > RacingCar.MAX_NAME_LENGTH) {
                throw new IllegalArgumentException(INVALID_NAME_LENGTH.getMessage() + ": " + name);
            }
        }
        return carNames;
    }


    private void createCars(List<String> validCarNames) {
        for (String name : validCarNames) {
            cars.add(new RacingCar(name.trim()));
        }
    }

    private int askTrialCount() {
        ioHandler.println(ASK_GAME_COUNT.getMessage());
        return ioHandler.getIntInput();
    }

}
