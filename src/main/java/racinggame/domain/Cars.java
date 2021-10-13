package racinggame.domain;

import racinggame.service.MovingStrategy;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars = new ArrayList<>();
    private WinnerNames winnerNames;

    public Cars(List<Car> carList) {
        cars = carList;
        winnerNames = new WinnerNames();
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public String findWinners() {
        int winnerPosition = getWinnerPosition();

        for (Car car : cars) {
            addWinner(car, winnerPosition);
        }

        return winnerNames.getWinnerNames();
    }

    private void addWinner(Car car, int winnerPosition) {
        if (car.isWinner(winnerPosition)) {
            winnerNames.addName(car.getCarName());
        }
    }

    private int getWinnerPosition() {
        int winnerPosition = 0;
        for (Car car : cars) {
            winnerPosition = Math.max(winnerPosition, car.getPosition());
        }
        return winnerPosition;
    }

    public void race(MovingStrategy movingStrategy) {
        for (Car car : cars) {
            car.move(movingStrategy);
        }
    }
}
