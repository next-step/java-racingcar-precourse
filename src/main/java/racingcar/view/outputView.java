package racingcar.view;

import java.util.List;
import org.assertj.core.util.Strings;
import racingcar.dto.GameHistories;
import racingcar.dto.GameHistory;
import racingcar.dto.GameResult;
import racingcar.model.Car;

public class outputView {

    private static final String RESULT = "실행 결과";

    private static final String LINE = "\n";

    private static final String COLON = " : ";

    private static final String WINNERS = "최종 우승자";

    public static void outputGamePlayHistories(List<GameHistories> gamePlayHistories) {
        System.out.println(RESULT);
        for (GameHistories gameHistories : gamePlayHistories) {
            outputGameHistory(gameHistories);
        }
    }

    private static void outputGameHistory(GameHistories gameHistories) {
        StringBuilder st = new StringBuilder();

        for (GameHistory gameHistory : gameHistories.getPlayHistories()) {
            st.append(gameHistory.getName() + COLON + gameHistory.getDistance());
            st.append(LINE);
        }

        System.out.println(st);
    }

    public static void outputGamerWinners(GameResult gameResult) {
        StringBuilder st = new StringBuilder();
        st.append(WINNERS + COLON);
        st.append(String.join(",", gameResult.getGameResult()));

        System.out.println(st);
    }
}
