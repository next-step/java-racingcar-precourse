package racingcar.View;

import racingcar.model.CurrentResult;
import racingcar.model.Message.ErrorMessage;
import racingcar.model.Message.OutputMessage;
import racingcar.model.WinnerResult;

public class OutputView {
    public static void printResult(CurrentResult gameResult) {
        System.out.println(gameResult.getResult());
    }

    public static void printWinners(WinnerResult winnerResult) {
        System.out.print(OutputMessage.OUTPUT_WINNERS);
        System.out.println(winnerResult.getPrintWinners());
    }

    public static void printError(IllegalArgumentException e) {
        System.out.print(ErrorMessage.ERROR_PRIFIX);
        System.out.println(e.getMessage());
    }
}
