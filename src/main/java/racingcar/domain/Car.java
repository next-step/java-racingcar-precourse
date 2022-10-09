package racingcar.domain;

import java.util.Objects;

public class Car {

    private final CarName carName;
    private final Position position;

    public Car(final String name) {
        this.carName = new CarName(name);
        this.position = new Position();
    }

    public void drive(final DriveStatus driveStatus) {
        if (driveStatus.isDrive()) {
            position.increase();
        }
    }

    public RaceStatus compete(final Car car) {
        if (compute(car)) {
            return RaceStatus.LOSE;
        }
        return RaceStatus.WINNE;
    }

    private boolean compute(final Car car) {
        return isNotSelf(car) && position.lessThan(car.position);
    }

    private boolean isNotSelf(final Car car) {
        return !car.equals(this);
    }

    public CarName getCarName() {
        return carName;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(getCarName(), car.getCarName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCarName());
    }
}
