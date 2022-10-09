package racingcar.view;

import java.util.Collections;
import java.util.List;
import racingcar.model.RacingCar;
import racingcar.model.ScoreBoard;

/**
 * @author: Minwoo Kim
 * @date 2022/10/09
 */
public class Output {

    private final static String GAME_RESULT_ANNOUNCE = "실행결과";
    private final static String WINNER_ANNOUNCE_PATTERN = "최종 우승자 : %s";
    private final static String CAR_STATUS_OUTPUT_PATTERN = "%s : %s";
    private final static String ONE_MOVE_OUTPUT_FORMAT = "-";
    private final static String NAME_SPLIT_STANDARD = ",";

    private static String repeatedMoveOutput(int n) {
        return String.join("", Collections.nCopies(n, ONE_MOVE_OUTPUT_FORMAT));
    }

    public static void initiativePrintStatus() {
        System.out.println(GAME_RESULT_ANNOUNCE);
    }


    public static void printStatus(ScoreBoard scoreBoard) {
        for (RacingCar car : scoreBoard.getRacingCarStats()) {
            String positionOutput = repeatedMoveOutput(car.getPosition());
            String message = String.format(CAR_STATUS_OUTPUT_PATTERN, car.getName(),
                positionOutput);
            System.out.println(message);
        }
        System.out.println();
    }


    public static void gameResultAnnounce(ScoreBoard scoreBoard) {
        List<String> winnerNames = scoreBoard.findWinners();
        String result = String.format(WINNER_ANNOUNCE_PATTERN,
            (String.join(NAME_SPLIT_STANDARD, winnerNames)));
        System.out.println(result);
    }

}
