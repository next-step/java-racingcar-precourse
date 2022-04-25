package racingcar.view;

import racingcar.model.RaceResults;
import racingcar.model.Winners;

public class Output {
    private static final String WINNER_PREFIX_MESSAGE = "최종 우승자:";
    private static final String ERROR_MESSAGE = "[ERROR]";

    public void printWinners(Winners winners) {
        System.out.println(WINNER_PREFIX_MESSAGE+winners);
    }

    public void printErrorMessage(String message) {
        System.out.println(ERROR_MESSAGE+message);
    }

    public void printResults(RaceResults roundResults) {
        System.out.println(roundResults);
    }
}
