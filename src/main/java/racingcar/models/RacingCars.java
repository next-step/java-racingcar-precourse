package racingcar.models;

import java.util.ArrayList;
import java.util.List;
import racingcar.common.exceptions.IllegalArgumentException;

public class RacingCars {

    private static final int MIN_LENGTH = 1;
    private final List<RacingCar> cars;

    public RacingCars(List<Car> cars) {
        if (cars.size() < MIN_LENGTH)
            throw new IllegalArgumentException("레이싱을 하려면 1대 이상의 자동차가 필요해요.");
        this.cars = mapToRacingCar(cars);
    }

    public List<RacingCar> get() {
        return this.cars;
    }

    private static List<RacingCar> mapToRacingCar(List<Car> cars) {
        List<RacingCar> racingCars = new ArrayList<>();
        for (Car car: cars) {
            racingCars.add(new RacingCar(car));
        }
        return racingCars;
    }

}
