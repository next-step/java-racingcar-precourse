package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Racing;
import racingcar.util.CarUtil;
import racingcar.view.ConsoleView;

public class RacingController {

    public static final String EMPTY = "";

    public void play() {

        ConsoleView.inputCarNames();
        String carNames = inputCarNames();

        ConsoleView.inputRound();
        String round = inputRound();

        Racing racing = new Racing(carNames, round);

        ConsoleView.printResultInfo();

        for (int i = 0; i < racing.getRound(); i++) {
            ConsoleView.printRoundResult(racing.move());
        }

        ConsoleView.printWinner(racing.getWinner());
    }

    public String inputCarNames() {
        String carNames = EMPTY;

        while (true) {
            carNames = Console.readLine();
            try {
                CarUtil.validateCarNames(carNames);
            } catch (IllegalArgumentException e) {
                carNames = EMPTY;
                ConsoleView.printError(e.getMessage());
            }

            if (!EMPTY.equals(carNames)) {
                break;
            }
        }

        return carNames;
    }

    public String inputRound() {
        String round = EMPTY;

        while (true) {
            round = Console.readLine();
            try {
                CarUtil.validateRound(round);
            } catch (IllegalArgumentException e) {
                ConsoleView.printError(e.getMessage());
                round = EMPTY;
            }

            if (!EMPTY.equals(round)) {
                break;
            }
        }

        return round;
    }

}
