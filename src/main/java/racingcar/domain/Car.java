package racingcar.domain;

import java.util.Objects;

public class Car {
    private static final int MOVE_NUMBER = 4; // 매직넘버 상수화
    private CarName name;
    private int position;

    public Car(CarName name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name.getName();
    }

    public int maxPosition() {
        return this.position;
    }

    public Car move(int randomNumber) {
        if (randomNumber >= MOVE_NUMBER) {
            this.position++;
        }
        return new Car(this.name, this.position);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
