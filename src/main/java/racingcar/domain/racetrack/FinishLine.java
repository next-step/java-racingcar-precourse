package racingcar.domain.racetrack;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.car.Position;

public class FinishLine {
    private final List<Car> allCars;
    private final List<Car> winnerCars = new ArrayList<>();
    private final List<String> winnerNames = new ArrayList<>();

    public FinishLine(List<Car> cars) {
        this.allCars = cars;
    }

    public Position getMaxPosition() {
        Position maxPosition = new Position(0);
        for (Car car : allCars) {
            maxPosition = car.getPosition().getBiggerPosition(maxPosition);
        }
        return maxPosition;
    }

    public void judgeWinners() {
        Position maxPosition = getMaxPosition();
        for (Car car : allCars) {
            addWinner(maxPosition, car);
        }
    }

    private void addWinner(Position maxPosition, Car car) {
        if (car.isLocated(maxPosition)) {
            winnerCars.add(car);
            winnerNames.add(car.getName());
        }
    }

    public List<Car> getWinners() {
        return this.winnerCars;
    }

    public List<String> getWinnerNames() {
        return this.winnerNames;
    }
}
