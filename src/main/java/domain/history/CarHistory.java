package domain.history;

import java.util.Objects;

import domain.name.CarName;
import domain.position.Position;

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
    public boolean equals(Object dest) {
        if (this == dest) {
            return true;
        }
        if (dest == null || getClass() != dest.getClass()) {
            return false;
        }

        CarHistory that = (CarHistory) dest;
        return Objects.equals(carName, that.carName) && Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, position);
    }
}
