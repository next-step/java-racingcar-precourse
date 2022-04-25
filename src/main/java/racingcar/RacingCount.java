package racingcar;

import java.util.Objects;

public class RacingCount {
    private final int count;

    public RacingCount(final int count) {
        validation(count);
        this.count = count;
    }

    private void validation(final int count) {
        if (count < 0) {
            throw new IllegalArgumentException("[ERROR] Don't input negative");
        }
    }

    public RacingCount decrease() {
        try {
            return new RacingCount(count-1);
        } catch (IllegalArgumentException e) {
            throw new IllegalStateException("Racing is finish");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCount that = (RacingCount) o;
        return count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}
