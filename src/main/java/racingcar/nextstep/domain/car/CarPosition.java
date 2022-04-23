package racingcar.nextstep.domain.car;

public class CarPosition {

    private final int value;

    public CarPosition(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static CarPosition zero() {
        return new CarPosition(0);
    }

    public static CarPosition of(int value) {
        return new CarPosition(value);
    }

    public static CarPosition addValue(int value) {
        return CarPosition.of(value + 1);
    }
}
