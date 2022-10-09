package racingcar.controller.console;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.Controller;
import racingcar.model.Attempts;
import racingcar.model.Cars;
import racingcar.model.MaxForwardCount;
import racingcar.model.Names;
import racingcar.model.Round;
import racingcar.view.View;

public class ConsoleController implements Controller {

    private final View view;
    private final Round round;

    public ConsoleController(View view, Round round) {
        this.view = view;
        this.round = round;
    }

    @Override
    public void start() {
        view.printCarNameInputMessage();
        Cars cars = new Cars(inputCarNames());
        view.printAttemptsInputMessage();
        Attempts attempts = inputAttempts();
        MaxForwardCount maxForwardCount = new MaxForwardCount();
        view.printRoundResultMessage();
        playAsNumberOfAttempts(attempts, cars, maxForwardCount);
        view.printWinner(round.getWinnerNames(cars, maxForwardCount));
    }

    private void playAsNumberOfAttempts(Attempts attempts, Cars cars, MaxForwardCount maxForwardCount) {
        int i = 0;
        while (i < attempts.getCount()) {
            round.play(cars, maxForwardCount);
            view.printCarForwardResult(cars);
            i++;
        }
    }

    @Override
    public Names inputCarNames() {
        try {
            return new Names(Console.readLine());
        } catch (IllegalArgumentException iae) {
            view.printErrorMessage(iae.getMessage());
            return inputCarNames();
        }
    }

    @Override
    public Attempts inputAttempts() {
        try {
            return new Attempts(Console.readLine());
        } catch (IllegalArgumentException iae) {
            view.printErrorMessage(iae.getMessage());
            return inputAttempts();
        }
    }
}