package racingcar.domain;

import java.util.Objects;

public class Car {
    public static final int MIN_NUMBER = 0;
    public static final int MAX_NUMBER = 9;
    private static final String INVALID_NUMBER_ERROR_MESSAGE = "[ERROR] 자동자 랜덤 값은 0 ~ 9 사이의 숫자여야 한다.";
    private static final int MIN_MOVABLE = 4;

    private final CarName name;
    private final CarMoveCount moveCount;

    Car(String name) {
        this.name = new CarName(name);
        this.moveCount = new CarMoveCount();
    }

    void moveForward(int number) {
        if (isInvalidNumber(number)) {
            throw new IllegalArgumentException(INVALID_NUMBER_ERROR_MESSAGE);
        }

        if (isMovable(number)) {
            this.moveCount.increase();
        }
    }

    int getMoveCount() {
        return this.moveCount.value();
    }

    String getName() {
        return this.name.value();
    }

    private boolean isInvalidNumber(int number) {
        return number < MIN_NUMBER || number > MAX_NUMBER;
    }

    private boolean isMovable(int number) {
        return number >= MIN_MOVABLE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

}
