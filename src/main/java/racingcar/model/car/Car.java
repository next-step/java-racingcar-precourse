package racingcar.model.car;

import racingcar.model.movement.MovementStatus;
import racingcar.model.movement.MovementStrategy;
import racingcar.model.record.CarRecord;

import java.util.List;
import java.util.Objects;

public class Car implements Comparable<Car> {
    private final CarName carName;
    private final CarPositions carPositions;

    public Car(String name) {
        this.carName = new CarName(name);
        this.carPositions = new CarPositions();
    }

    public void race(MovementStrategy movementStrategy) {
        MovementStatus movementStatus = movementStrategy.race();

        carPositions.recordPosition(movementStatus);
    }

    public String getName() {
        return carName.getName();
    }

    public int getPosition() {
        return carPositions.getPosition();
    }

    public List<Integer> getPositions() {
        return carPositions.getPositions();
    }

    public CarRecord convertCarRecord(int maxPosition) {
        return new CarRecord(getName(), getPositions(), isChampion(maxPosition));
    }

    private boolean isChampion(int maxPosition) {
        return getPosition() == maxPosition;
    }

    @Override
    public int compareTo(Car o) {
        return getPosition() - o.getPosition();
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
        return Objects.equals(getName(), car.getName()) && Objects.equals(getPosition(), car.getPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, carPositions);
    }
}
