package racingcar.model;

import java.util.Objects;

import static racingcar.util.Payload.ERROR_NAME_LENGTH;
import static racingcar.util.Scale.NAME_MAX_LENGTH;


public class Car {
    private String name;
    private Spot spot;

    public Car(String name, Spot spot) {
        validate(name);
        this.name = name;
        this.spot = spot;
    }

    public Car(String name) {
        this(name, new Spot());
    }

    private void validate(String name) {
        int length = name.length();
        if (length > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(ERROR_NAME_LENGTH + length);
        }

    }

    public Spot spot() {
        return this.spot;
    }

    public boolean isFasterThan(Spot maxSpot) {
        return this.spot.isFartherThan(maxSpot);
    }

    public boolean isAtIdenticalSpot(Spot maxSpot) {
        return this.spot.isAtIdenticalSpot(maxSpot);
    }

    public void move() {
        this.spot = this.spot.move();
    }

    public String name() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(spot, car.spot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, spot);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", spot=" + spot +
                '}';
    }
}
