package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameResult {
    List<GameStatus> status = new ArrayList<>();

    public int totalExecuteCount() {
        return status.size();
    }

    public void addStatus(GameStatus gameStatus) {
        this.status.add(gameStatus);
    }

    public List<GameStatus> getGameResult() {
        return Collections.unmodifiableList(status);
    }
}
