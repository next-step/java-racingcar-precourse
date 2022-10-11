package racingcar.car;

import racingcar.car.value.CarName;
import racingcar.car.value.Position;
import racingcar.common.util.Output;
import racingcar.common.util.StringFormat;

import java.util.Objects;

public class Car implements Comparable<Car>{
    private CarName carName;
    private Position position;

    public Car(String carName) {
        this.carName = new CarName(carName);
        this.position = new Position();
    }

    public void move() {
        this.position.move();
    }

    public int position(){
        return this.position.position();
    }

    public String name() {
        return this.carName.value();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(carName, car.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }

    @Override
    public int compareTo(Car o) {
        return this.position() - o.position();
    }

    @Override
    public String toString() {
        return carName + " : " + StringFormat.positionToDash(position.position()) ;
    }
}
