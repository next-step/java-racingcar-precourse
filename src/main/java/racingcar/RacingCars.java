package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    private static final String RACING_CAR_NAME_SPLITER = ",";

    private final List<RacingCar> racingCars;

    public RacingCars(String racingCarNames) {
        this.racingCars = new ArrayList<>();
        if (!validateRacingCarNames(racingCarNames)) {
            throw new IllegalArgumentException(ErrorMessage.RACING_CAR_NAME_SPLITER_ERROR);
        }
        initRacingCars(racingCarNames);
    }

    private void initRacingCars(String racingCarNames) {
        String[] racingCarArray = racingCarNames.split(RACING_CAR_NAME_SPLITER);
        for (String racingCar : racingCarArray) {
            racingCars.add(new RacingCar(racingCar));
        }
    }

    public void play(String commandCount) {
        CommandCount count = new CommandCount(commandCount);
        for (RacingCar racingCar : racingCars) {
            racingCar.command(count);
        }
        endGame();
    }

    private void endGame() {
        getWinner();
    }

    private void getWinner() {
        List<RacingCar> winners = new ArrayList<>();
        RacingCar max = racingCars.get(0);
        winners.add(max);
        for (int i = 1; i < racingCars.size(); i++) {
            max = getMax(winners, max, racingCars.get(i));
        }
        printResult(winners);
    }

    private void printResult(List<RacingCar> winners) {
        printAll();
        printWinner(winners);
    }

    private void printAll() {
        for (RacingCar racingCar : racingCars) {
            System.out.println(racingCar);
        }
    }

    private void printWinner(List<RacingCar> winners) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < winners.size(); i++) {
            stringBuilder.append(winners.get(i).getRacingCarName());
            if (i < winners.size() - 1) {
                stringBuilder.append(", ");
            }
        }
        System.out.println("최종 우승자: " + stringBuilder);
    }


    private RacingCar getMax(List<RacingCar> winner, RacingCar max, RacingCar temp) {
        RacingCar result = isTempMax(winner, max, temp) ? temp : max;
        isTempEqual(winner, max, temp);
        return result;
    }

    private void isTempEqual(List<RacingCar> winner, RacingCar max, RacingCar temp) {
        if (max.compareTo(temp) == 0) {
            winner.add(temp);
        }
    }

    private boolean isTempMax(List<RacingCar> winner, RacingCar max, RacingCar temp) {
        if (max.compareTo(temp) < 0) {
            winner.clear();
            winner.add(temp);
            return true;
        }
        return false;
    }

    private boolean validateRacingCarNames(String racingCarNames) {
        return racingCarNames.contains(RACING_CAR_NAME_SPLITER);
    }

}
