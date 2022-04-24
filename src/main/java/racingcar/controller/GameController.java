package racingcar.controller;

import racingcar.constant.ConsoleMessage;
import racingcar.exception.CustomIllegalArgumentException;
import racingcar.exception.CustomNumberFormatException;
import racingcar.model.Cars;
import racingcar.model.PlayResult;
import racingcar.model.Repeat;
import racingcar.utils.ConsoleUtil;

public class GameController {

    public void start() {
        Cars cars = readCarsName();
        Repeat repeat = readRepeatTime();
        playGame(cars, repeat);
        playResult(cars);
    }

    private void playResult(Cars cars) {
        PlayResult result = cars.findWinner();
        ConsoleUtil.print(ConsoleMessage.WINNER);
        ConsoleUtil.print(result.resultSetting());
    }

    private void playGame(Cars cars, Repeat repeat) {
        while (!repeat.isEnd()) {
            cars.move();
            ConsoleUtil.printStep(cars);
            repeat.reduce();
        }
    }

    private Repeat readRepeatTime() {
        try {
            ConsoleUtil.print(ConsoleMessage.ENTER_REPEAT);
            return ConsoleUtil.readRepeatTime();
        } catch (CustomNumberFormatException | CustomIllegalArgumentException exception) {
            ConsoleUtil.printError(exception);
            return readRepeatTime();
        }
    }

    private Cars readCarsName() {
        try {
            ConsoleUtil.print(ConsoleMessage.ENTER_CAR_NAMES);
            return ConsoleUtil.readCarsName();
        } catch (CustomIllegalArgumentException exception) {
            ConsoleUtil.printError(exception);
            return readCarsName();
        }
    }
}
