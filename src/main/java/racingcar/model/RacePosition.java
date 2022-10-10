package racingcar.model;

public class RacePosition {

    private int position;

    public RacePosition() {
        position = 0;
    }

    public void move(int number) {
        if (number >= 4) {
            this.position++;
        }
    }

    public int get() {
        return position;
    }

    public void update(RacePosition other) {
        if (other == null) {
            throw new NullPointerException("input RacePosition is null");
        }
        if (other.position > position) {
            this.position = other.position;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o instanceof RacePosition) {
            return ((RacePosition) o).position == position;
        }
        return false;
    }
}
