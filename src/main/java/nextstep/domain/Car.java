package nextstep.domain;

import java.util.NoSuchElementException;
import java.util.Objects;

public class Car {

    private static final int MAX_LENGTH = 5;
    private static final int DEFAULT_DISTANCE = 0;
    private static final int MIN_MOVABLE_VALUE = 4;

    private final String name;
    private int distance;

    public Car(String name) {
        checkName(name);
        this.name = name;
        this.distance = DEFAULT_DISTANCE;
    }

    private void checkName(String name) {
        if (Objects.isNull(name) || name.isEmpty()) {
            throw new NoSuchElementException("[ERROR] 자동차 이름은 빈값이 될 수 없습니다.");
        }
        if (name.length() > MAX_LENGTH) {
            throw new NoSuchElementException("[ERROR] 자동차 이름은 5글자 이하만 가능합니다.");
        }
    }

    public MoveResult move(int number) {
        if (number >= MIN_MOVABLE_VALUE) {
            this.distance++;
        }
        return new MoveResult(this.name, this.distance);
    }

    public String getName() {
        return this.name;
    }

    public int getDistance() {
        return distance;
    }

    public boolean isEqual(int distance) {
        return this.distance == distance;
    }

    public boolean isGreaterThanEqual(int distance) {
        return this.distance >= distance;
    }
}
