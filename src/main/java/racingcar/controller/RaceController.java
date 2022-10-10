package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.common.Messages;
import racingcar.model.Cars;
import racingcar.model.Race;
import racingcar.model.RaceCount;
import racingcar.model.RacePosition;

public class RaceController {

    public RaceController() {
        Cars cars = generateCars();
        RaceCount raceCount = generateRaceCount();
        RacePosition topPosition = new RacePosition();
        Race race = new Race(raceCount, topPosition);
        Messages.EMPTY.println();
        Messages.RESULT_EXECUTE.println();
        race.start(cars.getCars());
    }

    private Cars generateCars() {
        Cars cars = new Cars();
        Messages.PLEASE_INPUT_CAR_NAMES.println();
        while (cars.isNotRegisteredCars()) {
            inputRegisterCarNames(cars);
        }
        return cars;
    }

    private void inputRegisterCarNames(Cars cars) {
        try {
            cars.generateCars(Console.readLine());
        } catch (IllegalArgumentException e) {
            printErrorMessage(e);
        }
    }

    private RaceCount generateRaceCount() {
        RaceCount raceCount = null;
        Messages.PLEASE_INPUT_RACE_COUNT.println();
        while (raceCount == null) {
            raceCount = inputRaceCountNumber();
        }
        return raceCount;
    }

    private RaceCount inputRaceCountNumber() {
        RaceCount raceCount = null;
        try {
            raceCount = RaceCount.generate(Console.readLine());
        } catch (IllegalArgumentException e) {
            printErrorMessage(e);
        }
        return raceCount;
    }

    private void printErrorMessage(Exception e) {
        Messages.ERROR.println(e.getMessage());
    }
}
