package racinggame;

import utils.RaceUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Map<String, Integer> getPlayerNamePositionMap() {
        Map<String, Integer> namePositionMap = new HashMap<>();
        for (Car car : this.cars) {
            namePositionMap.put(car.getCarName(), car.getCarPosition());
        }
        return namePositionMap;
    }

    public List<Car> getTopPlayers() {
        int maxPosition = maxPositionOfCars(this.cars);
        return getCarsWithMaxPosition(maxPosition);
    }

    private List<Car> getCarsWithMaxPosition(int maxPosition) {
        List<Car> list = new ArrayList<>();
        for (Car car : this.cars) {
            addCarWithMaxPosition(maxPosition, list, car);
        }
        return list;
    }

    private void addCarWithMaxPosition(int maxPosition, List<Car> list, Car car) {
        if (car.getCarPosition() == maxPosition) {
            list.add(car);
        }
    }

    private static int maxPositionOfCars(List<Car> cars) {
        int max = 0;
        for (Car car : cars) {
            max = Math.max(max, car.getCarPosition());
        }
        return max;
    }
}
