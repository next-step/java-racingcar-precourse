package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Winner {

    private List<Car> cars;

    public Winner(List<Car> cars) {
        this.cars = cars;
    }

    public String findFinalWinningCars() {
        StringJoiner finalWinningCars = new StringJoiner(Delimiter.getDELIMITER());
        List<CarName> winningCars = findWinningCars();
        for (CarName winningCar : winningCars) {
            finalWinningCars.add(winningCar.getName());
        }

        return finalWinningCars.toString();
    }

    public List<CarName> findWinningCars() {
        List<CarName> winningCars = new ArrayList<>();
        for (Car car : cars) {
            winningCars = findWinningCar(car, winningCars);
        }

        return winningCars;
    }

    private List<CarName> findWinningCar(Car car, List<CarName> winningCars) {
        int farthestDistance = findFarthestDistance();
        if (farthestDistance == car.getDistance()) {
            winningCars.add(car.getName());
        }

        return winningCars;
    }

    private int findFarthestDistance() {
        int farthestDistance = Integer.MIN_VALUE;
        for (Car car : cars) {
            farthestDistance = Math.max(farthestDistance, car.getDistance());
        }

        return farthestDistance;
    }
}
