package racingcar.domain;

public class Position {
    private int position;

    public Position(int position) {
        this.position = position;
    }

    public int getPosition() {
        return this.position;
    }

    public void increasePosition() {
        this.position++;
    }

    public boolean isEqualPosition(Position position) {
        return this.position == position.getPosition();
    }

    public boolean isFrontPosition(Position position) {
        return this.position > position.getPosition() ? true : false;
    }
}
