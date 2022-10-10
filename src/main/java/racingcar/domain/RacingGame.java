package racingcar.domain;

import java.util.List;

public class RacingGame {
    private Cars cars;
    private final MovingStrategy movingStrategy;
    public RacingGame(MovingStrategy movingStrategy) {
        this.movingStrategy = movingStrategy;
    }

    public void createCars(List<Car> cars) {
        this.cars = new Cars(cars);
    }

    public void moveCars() {
        cars.moveCars(movingStrategy);
    }

    public String getMoveResult() {
        return cars.getMoveResult();
    }

    public String getWinnerText() {
        StringBuilder sb = new StringBuilder();
        for(Car car : cars.getWinners()) {
            sb.append(car.getName()).append(", ");
        }
        return sb.substring(0, sb.length()-2);
    }
}
