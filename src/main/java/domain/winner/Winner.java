package domain.winner;

import domain.name.CarName;

import java.util.Objects;

public class Winner {
    private CarName carName;

    public Winner(CarName carName) {
        this.carName = carName;
    }

    public CarName getCarName() {
        return carName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Winner winner = (Winner) o;
        return Objects.equals(carName, winner.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }
}
