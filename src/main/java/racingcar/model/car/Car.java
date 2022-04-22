package racingcar.model.car;

import racingcar.dto.CarRecordDto;
import racingcar.model.movement.MovementStatus;
import racingcar.model.movement.MovementStrategy;

import java.util.List;
import java.util.Objects;

public class Car implements Comparable<Car> {
    private final CarName name;
    private final CarPositions positions;

    public Car(String name) {
        this.name = new CarName(name);
        this.positions = new CarPositions();
    }

    public void race(MovementStrategy movementStrategy) {
        MovementStatus movementStatus = movementStrategy.race();

        positions.recordPosition(movementStatus);
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return positions.getPosition();
    }

    public CarRecordDto convertCarRecord(int maxPosition) {
        return new CarRecordDto(getName(), getPositions(), isWinner(maxPosition));
    }

    public List<Integer> getPositions() {
        return positions.getPositions();
    }

    private boolean isWinner(int maxPosition) {
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
        return Objects.equals(getName(), car.getName()) && Objects.equals(getPositions(), car.getPositions());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPositions());
    }
}
