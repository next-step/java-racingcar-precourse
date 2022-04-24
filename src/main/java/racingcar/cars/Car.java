package racingcar.cars;

import racingcar.firstcollections.Positive;
import racingcar.utils.ValidationUtils;

public class Car {

    public static final int MINIMUM_SPEED = 0;
    public static final int MAXIMUM_SPEED = 9;
    private static final int FIXED_SPEED = 1;
    private static final int BOUNDED_SPEED = 4;
    private static final int STOP_SPEED = 0;

    private final String name;
    private final Positive distance;

    public Car(final String name) {
        if (!ValidationUtils.validateCarName(name, ValidationUtils.CAR_NAME_LENGTH_LIMIT)) {
            throw new IllegalArgumentException("잘못된 입력");
        }
        this.name = name;
        this.distance = new Positive(Positive.MIN_VALUE);
    }

    public Car(final String name, Positive distance) {
        if (!ValidationUtils.validateCarName(name, ValidationUtils.CAR_NAME_LENGTH_LIMIT)) {
            throw new IllegalArgumentException("잘못된 입력");
        }
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return this.name;
    }

    public long getDistance() {
        return this.distance.get();
    }

    public void move(final int randomNumber) {
        for (int i = 0; i < accelerator(randomNumber); i++) {
            this.distance.add();
        }
    }

    public boolean isMaxPosition(final Car car) {
        return this.getDistance() == car.getDistance();
    }

    private int accelerator(final int randomNumber) {
        if (BOUNDED_SPEED <= randomNumber) {
            return FIXED_SPEED;
        }
        return STOP_SPEED;
    }
}
