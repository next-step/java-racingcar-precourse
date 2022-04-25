package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars(String[] names) {
        cars = new ArrayList<>();
        for (String name : names) {
            Car car = new Car(name);
            cars.add(car);
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public int size() {
        return cars.size();
    }

    public void move() {
        for (Car car : cars) {
            car.moveRandomNumberStrategy();
        }
    }

    public List<String> getWinnersNames() {
        List<String> winners = new ArrayList<>();
        int max = getMax();
        for (Car car : cars) {
            addWinners(winners, max, car);
        }
        return winners;
    }

    private int getMax() {
        int max = 0;
        for (Car car : cars) {
            max = getBigger(max, car.getPosition());
        }
        return max;
    }

    private int getBigger(int max, int position) {
        return Math.max(max, position);
    }

    private void addWinners(List<String> winners, int max, Car car) {
        if (car.getPosition() == max) {
            winners.add(car.getName());
        }
    }

}
