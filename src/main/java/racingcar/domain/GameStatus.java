package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameStatus {
    private final List<Integer> gameStatus = new ArrayList<>();
    public GameStatus(List<Integer> gameStatus) {
        this.gameStatus.addAll(gameStatus);
    }

    public List<Integer> getGameStatus() {
        return Collections.unmodifiableList(gameStatus);
    }

    public int getMaxPosition() {
        int max = 0;
        for(Integer position : gameStatus) {
            if (position > max) {
                max = position;
            }
        }
        return max;
    }
}
