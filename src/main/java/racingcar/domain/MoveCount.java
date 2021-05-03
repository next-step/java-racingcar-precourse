package racingcar.domain;

import java.util.Objects;

public class MoveCount {
    private static final int MIN_NUMBER = 0;
    private static final String INVALID_MESSAGE = "0 보다 큰 숫자를 입력해 주세요.";

    private final int count;

    public MoveCount(String userCount) {
        try {
            this.count = Integer.parseInt(userCount);
        } catch (Exception e) {
            throw new IllegalArgumentException(INVALID_MESSAGE);
        }
        if (this.count <= MIN_NUMBER) {
            throw new IllegalArgumentException(INVALID_MESSAGE);
        }
    }

    public int getCount() {
        return this.count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoveCount moveCount = (MoveCount) o;
        return count == moveCount.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }

    @Override
    public String toString() {
        return "MoveCount{" +
                "count=" + count +
                '}';
    }
}
