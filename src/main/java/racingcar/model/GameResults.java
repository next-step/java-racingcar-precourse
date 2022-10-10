package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class GameResults {
    private final List<GameResult> gameResults;

    public GameResults() {
        this.gameResults = new ArrayList<>();
    }

    public void addGameResult(GameResult gameResult) {
        gameResults.add(gameResult);
    }

    public List<GameResult> getGameResults() {
        return gameResults;
    }

    public int size() {
        return gameResults.size();
    }

    public GameResult getGameResult(int idx) {
        return gameResults.get(idx);
    }

    public GameResult lastGameResult() {
        int lastIdx = size() - 1;
        return getGameResult(lastIdx);
    }
}
