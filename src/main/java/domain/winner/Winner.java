package domain.winner;

import java.util.Objects;

import domain.name.CarName;

public class Winner {
    private CarName carName;

    public Winner(CarName carName) {
        this.carName = carName;
    }

    public CarName getCarName() {
        return carName;
    }

    @Override
    public boolean equals(Object dest) {
        if (this == dest) {
            return true;
        }
        if (dest == null || getClass() != dest.getClass()) {
            return false;
        }

        Winner winner = (Winner) dest;
        return Objects.equals(carName, winner.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }
}
