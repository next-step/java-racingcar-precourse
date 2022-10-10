package racingcar.domain;

import java.util.Objects;

public class GameCount {
    private final static int GAME_END_COUNT = 0;

    private final int count;

    public GameCount(int count) {
        this.count = count;
    }

    public GameCount(String inputGameCount) {
        try {
            this.count = Integer.parseInt(inputGameCount);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("시도 횟수는 숫자여야 한다.");
        }
    }

    public GameCount downCount() {
        return new GameCount(count - 1);
    }

    public boolean isLeft() {
        return count > GAME_END_COUNT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GameCount gameCount = (GameCount) o;
        return count == gameCount.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}
