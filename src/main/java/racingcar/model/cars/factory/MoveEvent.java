package racingcar.model.cars.factory;

public class MoveEvent {
    private final int value;

    private MoveEvent(int value) {
        MoveEventValidator.assertValid(value);
        this.value = value;
    }

    public static MoveEvent of(int value) {
        return new MoveEvent(value);
    }

    public int get() {
        return value;
    }
}
