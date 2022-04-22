package racingcar.car;

public class RacingCarPosition {
    private final int position;

    public RacingCarPosition(int position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RacingCarPosition that = (RacingCarPosition) o;
        return position == that.position;
    }

    public int getPosition() {
        return position;
    }
}
