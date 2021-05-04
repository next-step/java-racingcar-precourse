package racingcargame.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars makeCars(String carNamesInput) {
        List<Car> cars = new ArrayList<>();
        CarNames carNames = CarNames.of(carNamesInput);
        for (CarName carName : carNames) {
            cars.add(Car.of(carName));
        }
        return new Cars(cars);
    }

    public int size() {
        return cars.size();
    }

    public void randomMove() {
        for (Car car : cars) {
            car.randomMove();
        }
    }

    public String getResultString() {
        StringBuilder resultString = new StringBuilder();
        for (Car car : cars) {
            resultString.append(car.getResultString());
        }
        return resultString.toString();
    }

    public Winners getWinners() {
        Integer maxMileage = 0;
        Winners winners = new Winners();
        for (Car car : cars) {
            maxMileage = addWinner(maxMileage, winners, car);
        }
        return winners;
    }

    private Integer addWinner(Integer maxMileage, Winners winners, Car car) {
        if (maxMileage.equals(car.getMileage().getMileage())) {
            winners.add(car);
        }
        if (maxMileage < car.getMileage().getMileage()) {
            maxMileage = car.getMileage().getMileage();
            winners.clear();
            winners.add(car);
        }
        return maxMileage;
    }

    public Car get(int i) {
        return cars.get(i);
    }
}
