package racingcar.domain;

import racingcar.util.Assert;

import java.util.Objects;

public class RacingCarPosition implements Comparable<RacingCarPosition> {

    private static final int STARTING_LINE_POSITION = 0;

    private int position;

    public RacingCarPosition(final Integer position) {
        Assert.notNull(position, String.format("자동차의 위치는 필수 값입니다. input: %d", position));
        Assert.notLessThan(position, STARTING_LINE_POSITION, String.format("자동차의 위치는 0 이상이어야 합니다. input: %d", position));

        this.position = position;
    }

    public static RacingCarPosition startingLine() {
        return new RacingCarPosition(STARTING_LINE_POSITION);
    }

    public void move() {
        this.position++;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RacingCarPosition)) {
            return false;
        }
        final RacingCarPosition that = (RacingCarPosition) o;
        return position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public int compareTo(final RacingCarPosition other) {
        return Integer.compare(this.position, other.position);
    }

    public int getPosition() {
        return position;
    }
}
