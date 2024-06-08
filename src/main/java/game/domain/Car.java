package game.domain;

import game.config.constant.Rule;
import game.validator.CarNameValidator;
import java.util.Objects;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        CarNameValidator.getInstance().validateNameLength(name);
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public int move(int randomValue) {
        if(canMove(randomValue)) {
            this.position++;
        }
        return this.position;
    }

    private boolean canMove(int randomValue) {
        return randomValue >= Rule.MOVEMENT_THRESHOLD;
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
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public String toString() {
        return "Car{" +
            "name='" + name + '\'' +
            ", position=" + position +
            '}';
    }
}
