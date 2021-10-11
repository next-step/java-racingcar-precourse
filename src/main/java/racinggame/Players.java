package racinggame;

import utils.RaceUtils;

import java.util.ArrayList;
import java.util.List;

public class Players {
    private static final int RANDOM_MIN = 1;
    private static final int RANDOM_MAX = 9;
    List<Car> cars;

    public Players(List<Car> cars) {
        this.cars = cars;
    }

    public static Players createPlayersByCarNames(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return new Players(cars);
    }

    public void moveCarsByConditions() {
        for (Car car : cars) {
            boolean goOrNot = determineGoOrNot(RaceUtils.randomNumber(RANDOM_MIN, RANDOM_MAX));
            car.move(goOrNot);
        }
    }

    protected static boolean determineGoOrNot(int num) {
        return num >= 4;
    }
}
