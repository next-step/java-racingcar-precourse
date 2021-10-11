package racinggame.view;

import racinggame.message.Message;

public class RacingCarView {

    private RacingCarView() {
    }

    public static String inputRacingCarName() {
        RacingCarOutput.println(Message.RACING_CAR_NAME_INPUT.getMessage());
        return RacingCarInput.inputUser();
    }

    public static String inputAttemptCount() {
        RacingCarOutput.println(Message.ATTEMPTS_COUNT_INPUT.getMessage());
        return RacingCarInput.inputUser();
    }

    public static void printRaceResult() {
        RacingCarOutput.println(Message.RACE_RESULT.getMessage());
    }

    public static void printFinalWinner(String winner) {
        RacingCarOutput.println(String.format(Message.FINAL_WINNER_RESULT.getMessage(), winner));
    }
}
