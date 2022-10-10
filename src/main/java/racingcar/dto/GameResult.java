package racingcar.dto;

import java.util.List;

public class GameResult {

    private final List<String> winnerNames;

    public GameResult(List<String> winnerNames) {
        this.winnerNames = winnerNames;
    }

    public List<String> getGameResult() {
        return this.winnerNames;
    }
}
