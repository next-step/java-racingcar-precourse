package racingcar.view;

import racingcar.message.Messages;
import racingcar.model.RacingResult;
import racingcar.model.ResultView;

public class RacingCarView {

    private RacingCarView() {
    }

    public static String inputRacingCarName() {
        RacingCarOutput.println(Messages.RACING_CAR_NAME_INPUT.getMessage());
        return RacingCarInput.inputUser();
    }

    public static String inputAttemptCount() {
        RacingCarOutput.println(Messages.ATTEMPTS_COUNT_INPUT.getMessage());
        return RacingCarInput.inputUser();
    }

    public static void printRaceResult(ResultView result) {
        RacingCarOutput.println(Messages.RACE_RESULT.getMessage());
        RacingCarOutput.println(result.result());
    }

    public static void printFinalWinner(String winner) {
        RacingCarOutput.println(String.format(Messages.FINAL_WINNER_RESULT.getMessage(), winner));
    }
}
