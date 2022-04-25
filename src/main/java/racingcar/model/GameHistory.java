package racingcar.model;

import java.util.LinkedList;
import java.util.List;

public class GameHistory {

    private final List<String> gameHistory;

    public GameHistory() {
        this.gameHistory = new LinkedList<>();
    }

    public List<String> getGameHistory() {
        return gameHistory;
    }

    public void record(String history) {
        gameHistory.add(history);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for(String history : gameHistory) {
            result.append(history);
            result.append(System.getProperty("line.separator"));
        }

        return result.toString();
    }
}
