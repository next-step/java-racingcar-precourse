package racingcar.race;

import racingcar.car.Car;
import racingcar.car.Cars;
import racingcar.common.factory.RandomFactory;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Race {
    private final RandomFactory randomFactory;
    private Cars cars = new Cars();

    public Race(RandomFactory randomFactory) {
        this.randomFactory = randomFactory;
    }

    public void join(Car car){
        this.cars.addCars(car);
    }

    public List<String> carNames(){
        return this.cars.getNames();
    }

    public List<Integer> carPositions() {
        return this.cars.getPositions();
    }

    public List<Car> moveCars() {
        cars.moveCars(randomFactory);
        return cars.carList();
    }

    public String winnerName() {
        return cars.winner();
    }
}
