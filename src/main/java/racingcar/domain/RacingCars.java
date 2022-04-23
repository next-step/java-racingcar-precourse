package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        this.cars = cars;
    }

    public void playRound() {
        for (Car car: cars) {
            car.move();
        }
    }

    public List<String> getWinnerNames() {
        return findWinnerNames(findMaxPosition());
    }

    private int findMaxPosition() {
        int position = Car.DEFAULT_POSITION;
        for (Car car: cars) {
            position = Math.max(car.getPosition(), position);
        }
        return position;
    }

    private List<String> findWinnerNames(int maxPosition) {
        List<String> winnerNames = new ArrayList<>();
        for (Car car: cars) {
            containWinner(winnerNames, car, maxPosition);
        }
        return winnerNames;
    }

    private void containWinner(List<String> winnerNames, Car car, int winnerPosition) {
        if (car.isWinner(winnerPosition)) {
            winnerNames.add(car.getName());
        }
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }
}
