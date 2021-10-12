package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars = new ArrayList<>();
    private List<String> winnerNames = new ArrayList<>();

    public Cars(List<Car> carList) {
        cars = carList;
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public List<String> findWinners() {
        int winnerPosition = getWinnerPosition();

        for (Car car : cars) {
            addWinner(car, winnerPosition);
        }

        return winnerNames;
    }

    private void addWinner(Car car, int winnerPosition) {
        if (car.isWinner(winnerPosition)) {
            winnerNames.add(car.getCarName());
        }
    }

    private int getWinnerPosition() {
        int winnerPosition = 0;
        for (Car car : cars) {
            winnerPosition = Math.max(winnerPosition, car.getPosition());
        }
        return winnerPosition;
    }
}
