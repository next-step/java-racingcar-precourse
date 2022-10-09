package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    private List<Car> cars;

    public List<Car> getRacingCars() {
        return cars;
    }

    public void initRacingCars(String carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames.split(",")) {
            cars.add(generatorEachRacingCar(carName));
        }
        this.cars = cars;
    }

    private Car generatorEachRacingCar(String carName) {
        Car car = new Car();
        car.initCarName(carName);
        car.initAdvanceCount();
        return car;
    }
}
