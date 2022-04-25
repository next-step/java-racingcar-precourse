package racingcar.domain;

import java.util.Objects;
import racingcar.domain.dto.CarDto;

public class Car {

    private final CarName carName;
    private final Position position;

    public Car(String carName, int position) {
        this.carName = new CarName(carName);
        this.position = new Position(position);
    }

    public Car(final String carName) {
        this(carName, 0);
    }

    public Car(CarName carName, Position position) {
        this.carName = carName;
        this.position = position;
    }

    public void move(MovingStrategy strategy) {
        if (strategy.isMovable()) {
            position.movePosition();
        }
    }

    public Position getMaxPosition(Position maxPosition) {
        return this.position.biggerThan(maxPosition) ? this.position : maxPosition;
    }

    public boolean isWinner(Position maxPosition) {
        return this.position.equals(maxPosition);
    }

    public CarDto convertDto() {
        return new CarDto(this.carName.getCarName(), this.position.getPosition());
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
        return Objects.equals(carName, car.carName) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, position);
    }

}
