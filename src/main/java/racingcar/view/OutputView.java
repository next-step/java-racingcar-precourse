package racingcar.view;

import racingcar.constant.ErrorMessageConst;
import racingcar.constant.StringConst;
import racingcar.constant.ViewMessageConst;
import racingcar.domain.RacingGame;
import racingcar.utils.ConvertUtils;

import java.util.List;

public class OutputView {
    public static void printError(String errorMessage) {
        System.out.println(ErrorMessageConst.ERROR_PREFIX + errorMessage);
    }

    public static void printRacingGameSingleRoundResult(RacingGame game) {
        System.out.println(ViewMessageConst.MESSAGE_PRINT_RACE_RESULT);
        List<String[]> currentCarsStatus = game.getCurrentCarsStatus();
        for (String[] status : currentCarsStatus) {
            printCarStatus(status);
        }
        System.out.print(StringConst.ESC_NEW_LINE);
    }

    public static void printRacingGameFinalResult(RacingGame game) {
        List<String> winnerNames = game.getWinnerNames();
        System.out.println(
                String.format(ViewMessageConst.MESSAGE_PRINT_WINNER_NAMES_FORMAT,
                        ConvertUtils.convertWinnerNamesListToString(winnerNames))
        );
    }

    private static void printCarStatus(String[] status) {
        System.out.println(
                String.format(ViewMessageConst.MESSAGE_PRINT_RACE_STATUS_FORMAT,
                        status[0], ConvertUtils.convertPositionToHyphenString(status[1]))
        );
    }
}
