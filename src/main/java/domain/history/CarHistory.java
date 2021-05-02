package domain.history;

import domain.position.Position;
import domain.name.CarName;

import java.util.Objects;

public class CarHistory {
    private CarName carName;
    private Position position;

    public CarHistory(CarName carName) {
        this(carName, new Position());
    }
    public CarHistory(CarName carName, Position position) {
        this.carName = carName;
        this.position = position;
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
        CarHistory that = (CarHistory) o;
        return Objects.equals(carName, that.carName) && Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, position);
    }
}
