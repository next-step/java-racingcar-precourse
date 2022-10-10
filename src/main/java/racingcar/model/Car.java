package racingcar.model;

import static racingcar.constants.Message.INVALID_CAR_NAME_PATTERN;

import racingcar.strategy.Move;

public class Car {

    private static final int MAX_NAME_LENGTH = 5;
    private static final int INIT_DISTANCE = 0;
    private final String name;
    private final Move moveStrategy;
    private int distance;

    public Car(String name, Move moveStrategy) {
        validate(name);
        this.name = name;
        this.moveStrategy = moveStrategy;
        this.distance = INIT_DISTANCE;
    }

    private void validate(final String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format(INVALID_CAR_NAME_PATTERN, MAX_NAME_LENGTH));
        }
    }

    public void move() {
        this.distance = moveStrategy.move(this.distance);
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
