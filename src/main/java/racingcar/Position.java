package racingcar;

public class Position {
    private int value;

    public Position(int value) {
        this.value = value;
    }

    public void move() {
        value++;
    }

    public int getValue() {
        return value;
    }
}
