package racingcar.service;

import racingcar.domain.Cars;
import racingcar.domain.RacingCnt;
import racingcar.view.ConsolePrinter;
import racingcar.view.ConsoleScanner;
import racingcar.view.Messages;

import java.util.List;

public class RacingCarService {
    private Cars cars = new Cars();
    private RacingCnt racingCnt;

    public void racingGameStart() {
        enrollRacing();
        getRacingCnt();
        racingStart();
        printWinnerNames();
    }

    private List<String> getCarNames() {
        ConsolePrinter.printConsoleMsg(Messages.ASK_RACING_CAR_NAMES);
        List<String> carNames = ConsoleScanner.getCarNames();
        return carNames;
    }

    private void enrollRacing() {
        try {
            cars.enrollRacing(getCarNames());
        } catch (IllegalArgumentException e) {
            enrollRacing();
            return;
        }
    }

    private void getRacingCnt() {
        ConsolePrinter.printConsoleMsg(Messages.ASK_RACING_CNT);
        try {
            racingCnt = new RacingCnt(ConsoleScanner.getUserInput());
        } catch (IllegalArgumentException e) {
            getRacingCnt();
            return;
        }
    }

    private void racingStart() {
        ConsolePrinter.printConsoleMsg(Messages.GAME_RESULT);
        for (int i = 0; i < racingCnt.getRacingCnt(); i++) {
            cars.moveCars();
            ConsolePrinter.printRacingResult(cars.getCars());
        }
    }

    private void printWinnerNames() {
        ConsolePrinter.printWinnerNames(cars.getWinnerNames());
    }

}
