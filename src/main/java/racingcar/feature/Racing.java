package racingcar.feature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Racing {
    private final List<Car> cars;

    public Racing(String input) {
        List<Car> cars = new ArrayList<>();
        CarName.makeCarName(input).forEach(carName -> cars.add(new Car(carName)));
        this.cars = cars;
    }

    public void progressAll(GameCount gameCount) {
        for (int i = 0; i < gameCount.getCount(); i++) {
            calculateScore();
            printProgress();
        }
    }

    public void printWinner() {
        System.out.println("최종 우승자: " + String.join(", ", makeWinners()));
    }

    private void calculateScore() {
        cars.forEach(Car::action);
    }

    private void printProgress() {
        cars.forEach(Car::printStatus);
        System.out.println();
    }

    private List<String> makeWinners() {
        int maxScore = calculateMaxScore();
        List<String> winners = new ArrayList<>();
        cars.forEach(car -> addWinner(winners, car, maxScore));
        return winners;
    }

    private void addWinner(List<String> winners, Car car, int maxScore) {
        if (car.isScore(maxScore)) {
            winners.add(car.getCarName());
        }
    }

    private int calculateMaxScore() {
        List<Integer> scores = new ArrayList<>();
        cars.forEach(car -> scores.add(car.getScoreCount()));
        return Collections.max(scores);
    }
}
