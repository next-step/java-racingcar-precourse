package racingcar.dto;

import java.util.List;

public class GameHistories {

    private final List<GameHistory> gameHistories;

    public GameHistories(List<GameHistory> gameHistories) {
        this.gameHistories = gameHistories;
    }

    public List<GameHistory> getPlayHistories() {
        return this.gameHistories;
    }
}
