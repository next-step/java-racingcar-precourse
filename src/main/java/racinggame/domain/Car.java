package racinggame.domain;

import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Name : Car <br/>
 * Description : 자동차 클래스
 */
public class Car {
    public static final int MAX_NAME_LENGTH = 5;
    public static final int MIN_NAME_LENGTH = 1;
    public static final int START_POSITION = 0;
    public static final int MOVE_FORWARD = 1;
    private final String name;
    private int position;

    public Car() {
        throw new IllegalArgumentException(ErrorCode.BLANK_NAME.getMessage());
    }

    public Car(String name) {
        if (isInvalidName(name)) {
            throw new IllegalArgumentException(ErrorCode.NAME_LENGTH_1TO5.getMessage());
        }
        this.name = name;
        this.position = START_POSITION;
    }

    private boolean isInvalidName(String name) {
        return name.trim().length() < MIN_NAME_LENGTH || name.trim().length() > MAX_NAME_LENGTH;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Car car = (Car) object;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public int getPosition() {
        return this.position;
    }

    public void move(int randomNumber) {
        if (MoveStatus.MOVE == CarMove.getMoveStatus(randomNumber)) {
            this.position += MOVE_FORWARD;
        }
    }
}
