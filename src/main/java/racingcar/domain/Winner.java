package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private final Cars cars;
    private List<String> winners;

    public Winner(Cars cars) {
        this.cars = cars;
    }

    public List<String> getWinners() {
        Position maxDistance = getMaxDistance();
        winners = new ArrayList<>();
        for (Car car : cars.cars()) {
            setWinner(car, maxDistance);
        }
        return winners;
    }

    private Position getMaxDistance() {
        Position result = new Position(0);
        for (Car car : cars.cars()) {
            result = setBiggerPosition(result, car.position());
        }
        return result;
    }

    private Position setBiggerPosition(Position position, Position otherPosition) {
        return (position.isBiggerPosition(otherPosition)) ? position : otherPosition;
    }

    private void setWinner(Car car, Position maxDistance) {
        if (car.position().isMaxPosition(maxDistance)) {
            winners.add(car.name().toString());
        }
    }
}
