package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public Cars(String[] carNames) {
        for (String carName : carNames) {
            this.cars.add(new Car(carName.trim()));
        }
    }

    public List<Car> getCarList() {
        return cars;
    }

    public void moveForwardRandom() {
        for (Car car : this.cars) {
            car.moveForwardRandom();
        }
    }

    public List<Car> getHighestScoreCars() {
        final int highestScore = getHighestScore();
        List<Car> highestScoreCars = new ArrayList<>();
        for (Car car : this.cars) {
            addCarIfScoreMatched(highestScore, highestScoreCars, car);
        }
        return highestScoreCars;
    }

    private int getHighestScore() {
        int highestScore = Integer.MIN_VALUE;
        for (Car car : this.cars) {
            highestScore = Math.max(car.getCarPosition(), highestScore);
        }
        return highestScore;
    }

    private void addCarIfScoreMatched(int highestScore, List<Car> highestScoreCars, Car car) {
        if (car.getCarPosition() == highestScore) {
            highestScoreCars.add(car);
        }
    }
}
