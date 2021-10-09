package racinggame.domain;

public class CarPosition {

    private int value;

    public CarPosition() {
        this.value = 0;
    }

    public CarPosition(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static CarPosition addValue(int value) {
        return CarPosition.of(value + 1);
    }

    public static CarPosition of(int value) {
        return new CarPosition(value);
    }
}
