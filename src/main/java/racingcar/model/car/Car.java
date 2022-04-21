package racingcar.model.car;

import racingcar.model.racing.RacingStatus;
import racingcar.model.racing.RacingStrategy;
import racingcar.model.record.CarRecord;

import java.util.Objects;
import java.util.Queue;

public class Car implements Comparable<Car> {
    private final CarName carName;
    private final CarPosition carPosition;

    public Car(String name) {
        this.carName = new CarName(name);
        this.carPosition = new CarPosition();
    }

    public void race(RacingStrategy racingStrategy) {
        RacingStatus racingStatus = racingStrategy.race();

        carPosition.recordPosition(racingStatus);
    }

    public String getName() {
        return carName.getName();
    }

    public int getPosition() {
        return carPosition.getPosition();
    }

    public Queue<Integer> getPositions() {
        return carPosition.getPositions();
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
        return Objects.hash(carName, carPosition);
    }
}
