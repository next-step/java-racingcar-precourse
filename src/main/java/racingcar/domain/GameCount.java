package racingcar.domain;

import java.util.Objects;

import static racingcar.exception.ErrorMessage.INVALID_GAME_COUNT;

public class GameCount {

    private final int gameCount;

    public GameCount(String gameCount) {
        try {
            this.gameCount = Integer.parseInt(gameCount);
        } catch (Exception exception) {
            throw new IllegalArgumentException(INVALID_GAME_COUNT);
        }
    }

    public int getGameCount() {
        return gameCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameCount gameCount1 = (GameCount) o;
        return gameCount == gameCount1.gameCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameCount);
    }
}
