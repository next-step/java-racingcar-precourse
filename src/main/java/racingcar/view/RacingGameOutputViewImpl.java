package racingcar.view;

import racingcar.domain.dto.PlayHistories;
import racingcar.domain.dto.PlayHistory;

import java.util.List;

public class RacingGameOutputViewImpl implements RacingGameOutputView {

    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String NAME_DISTANCE_MESSAGE = "%s : %s";
    private static final String WINNER_MESSAGE = "최종 우승자: %s";
    private static final String LINE_SEPARATOR = "\n";

    @Override
    public void outputTotalPlayHistories(final List<PlayHistories> totalPlayHistories) {
        System.out.println(LINE_SEPARATOR + RESULT_MESSAGE);
        for (PlayHistories roundHistories : totalPlayHistories) {
            outputRoundPlayHistories(roundHistories.getPlayHistories());
        }
    }

    @Override
    public void outputWinner(final List<String> winnerCarNames) {
        System.out.printf(WINNER_MESSAGE, String.join(",", winnerCarNames));
    }

    @Override
    public void outputErrorMessage(final String message) {
        System.out.println(message);
    }

    private void outputRoundPlayHistories(final List<PlayHistory> roundPlayHistories) {
        StringBuilder stringBuilder = new StringBuilder();
        for (PlayHistory playHistory : roundPlayHistories) {
            stringBuilder.append(String.format(NAME_DISTANCE_MESSAGE
                    , playHistory.getCarName(), convertDistanceText(playHistory.getDistance())));
            stringBuilder.append(LINE_SEPARATOR);
        }

        System.out.println(stringBuilder);
    }

    private String convertDistanceText(final int distance) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }
}