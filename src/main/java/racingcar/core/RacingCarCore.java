package racingcar.core;

import racingcar.domain.AttemptsNumber;
import racingcar.domain.CarNamesInput;
import racingcar.domain.Cars;
import racingcar.domain.IndexNumber;
import racingcar.domain.Winners;
import racingcar.enums.ResultEnum;
import racingcar.service.RacingCarService;
import racingcar.view.ConsoleView;
import racingcar.view.ErrorView;

public class RacingCarCore {
    private RacingCarService racingCarService;
    private ConsoleView consoleView;
    private ErrorView errorView;

    public void process() {
        initProcess();
        processSetCarNames();
        AttemptsNumber attemptsNumber = processReadAttemptsNumber();

        processPlayRace(attemptsNumber);
        processDeclareWinners();
    }

    private void initProcess() {
        racingCarService = new RacingCarService();
        consoleView = new ConsoleView();
        errorView = new ErrorView();
    }

    private void processSetCarNames() {
        ResultEnum result = ResultEnum.FAIL;
        while (result != ResultEnum.SUCCESS) {
            result = processSetCarNamesWithException();
        }
    }

    private ResultEnum processSetCarNamesWithException() {
        try {
            CarNamesInput input = consoleView.readCarNamesInput();
            racingCarService.initService(input);
            return ResultEnum.SUCCESS;
        } catch (IllegalArgumentException exception) {
            errorView.printErrorMessage(exception);
            return ResultEnum.FAIL;
        }
    }

    private AttemptsNumber processReadAttemptsNumber() {
        AttemptsNumber number = null;

        while (number == null) {
            number = processReadAttemptsNumberWithException();
        }

        return number;
    }

    private AttemptsNumber processReadAttemptsNumberWithException() {
        AttemptsNumber number = null;

        try {
            number = consoleView.readAttemptsNumber();
        } catch (IllegalArgumentException exception) {
            errorView.printErrorMessage(exception);
        }

        return number;
    }

    private void processPlayRace(AttemptsNumber attemptsNumber) {
        consoleView.printRaceStart();

        for (IndexNumber index = new IndexNumber(); index.getIndexNumber() < attemptsNumber.getAttemptsNumber();
             index.increaseIndex()) {
            Cars cars = racingCarService.playRace();
            consoleView.printCurrentCarsPosition(cars);
        }
    }

    public void processDeclareWinners() {
        Winners winners = racingCarService.getWinners();
        consoleView.printWinners(winners);
    }
}
