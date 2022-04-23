package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.strategy.RandomNumberMoveStrategy;
import racingcar.utils.WordUtils;

public class Cars {
    private final String carNames;
    private final List<Car> cars;

    public Cars(String carNames) {
        this.carNames = carNames;
        this.cars = new ArrayList<>();
        createCars();
    }

    private void createCars() {
        String[] carNameList = carNames.split(WordUtils.COMMA);

        for (String carName : carNameList) {
            addCar(carName.trim());
        }
    }

    private void addCar(String name) {
        Car car = new Car(name, new RandomNumberMoveStrategy());
        this.cars.add(car);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void move() {
        for (Car car : cars) {
            car.move();
        }

        System.out.println();
    }
}
