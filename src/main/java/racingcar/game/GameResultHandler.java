package racingcar.game;

import java.util.Map;
import racingcar.domain.RaceResult;

public class GameResultHandler {

    public static final String COMMA_DELIMITER = ", ";
    public static final String SPACE = " ";
    public static final String EMPTY_STRING = "";

    private GameResultHandler() {}

    public static GameResultHandler create() {
        return new GameResultHandler();
    }

    public String pickWinner(RaceResult result) {

        StringBuilder resultBuilder = new StringBuilder(EMPTY_STRING);
        int longestDistance = result.longestDistance();

        Map<String, String> map = result.eachCarPosition();
        for (String name : map.keySet()) {
            String distance = map.get(name);
            winner(name, distance, longestDistance, resultBuilder);
        }

        return separateToComma(resultBuilder);
    }

    private String separateToComma(StringBuilder resultBuilder) {
        String result = resultBuilder.toString();
        return String.join(COMMA_DELIMITER, result.split(SPACE));
    }

    private void winner(String name, String distance, int longestDistance, StringBuilder resultBuilder) {
        if (isSame(distance.length(), longestDistance)) {
            resultBuilder.append(name).append(SPACE);
        }
    }

    private boolean isSame(int source, int target) {
        return source == target;
    }

}
