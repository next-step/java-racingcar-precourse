package racingcar.domain;

import java.util.Objects;

public class Car {

    private final String name;
    private final Distance distance;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.distance = new Distance(0);
    }

    public String getName() {
        return name;
    }

    private void validateName(String name) {
        if (name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다");
        }
    }

    public Distance move(MovingCondition condition) {
        if (condition.isMovable()) {
            distance.add();
            return distance;
        }

        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
