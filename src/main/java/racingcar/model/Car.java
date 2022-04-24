package racingcar.model;

import racingcar.constants.CarMessage;

public class Car {
    private static final int MOVING_MIN_NUMBER = 4;
    public static final int MIN_NUMBER = 0;
    public static final int MAX_NUMBER = 9;

    private final Name name;
    private final Position position;

    private Car(Name name) {
        this.name = name;
        this.position = Position.create();
    }

    public static Car create(Name name) {
        return new Car(name);
    }

    public void move(int number) {
        validateNumberRange(number);
        if (isMoving(number)) {
            position.moveValue();
        }
    }

    boolean isMoving(int number) {
        return number >= MOVING_MIN_NUMBER;
    }

    void validateNumberRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(CarMessage.INVALID_NUMBER_RANGE);
        }
    }

    public String getName() {
        return name.getName();
    }

    public Position getPosition() {
        return position;
    }
}
