package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class GameResult {

    private int max;
    private final List<Car> cars;

    public GameResult(List<Car> cars) {
        this.cars = cars;
        for (Car car : cars) {
            updateMax(car);
        }
    }

    private void updateMax(Car car) {
        if (car.getPosition() > max) {
            max = car.getPosition();
        }
    }

    public String getWinnerName() {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            addWinner(winners, car);
        }

        return String.join(",", winners);
    }

    private void addWinner(List<String> winners, Car car) {
        if (car.getPosition() == max) {
            winners.add(car.getName());
        }
    }
}
