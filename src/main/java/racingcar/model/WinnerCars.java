package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class WinnerCars {
    public static List<Car> findWinnerCars(List<Car> cars) {
        return getWinnerCars(cars, getWinnerPosition(cars));
    }

    private static List<Car> getWinnerCars(List<Car> cars, int winnerPosition) {
        List<Car> winnerCars = new ArrayList<>();
        for (Car car : cars) {
            setWinnerCars(winnerPosition, winnerCars, car);
        }
        return winnerCars;
    }

    private static void setWinnerCars(int winnerPosition, List<Car> winnerCars, Car car) {
        if (car.isWinnerPosition(winnerPosition)) {
            winnerCars.add(car);
        }
    }

    private static int getWinnerPosition(List<Car> cars) {
        int winnerPosition = 0;
        for (Car car : cars) {
            winnerPosition = isWinnerPosition(winnerPosition, car);
        }
        return winnerPosition;
    }

    private static int isWinnerPosition(int winnerPosition, Car car) {
        if (car.isWinnerPosition(winnerPosition)) {
            return car.getPosition();
        }
        return winnerPosition;
    }
}
