package racingcar.model;

import racingcar.constant.Symbol;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Winner {
    private List<Car> cars;

    public Winner(List<Car> cars) {
        this.cars = cars;
    }

    public String searchFinalWinningCars() {
        StringJoiner finalWinningCars = new StringJoiner(Symbol.DELIMITER.getValue());
        List<CarName> winningCars = searchWinningCars();
        for(CarName winningCar : winningCars) {
            finalWinningCars.add(winningCar.getName());
        }
        return finalWinningCars.toString();
    }

    public List<CarName> searchWinningCars() {
        List<CarName> winningCars = new ArrayList<>();
        for (Car car : cars) {
            winningCars = searchWinningCar(car, winningCars);
        }

        return winningCars;
    }

    private List<CarName> searchWinningCar(Car car, List<CarName> winningCars) {
        int farthestDistance = searchMaxDistance();
        if (farthestDistance == car.getDistance()) {
            winningCars.add(car.getName());
        }

        return winningCars;
    }

    private int searchMaxDistance() {
        int maxDistance = Integer.MIN_VALUE;
        for (Car car : cars) {
            maxDistance = Math.max(maxDistance, car.getDistance());
        }

        return maxDistance;
    }
}
