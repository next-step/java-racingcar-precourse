package racingcar.domain;

import racingcar.utils.RandomNumberPicker;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    private final RandomNumberPicker picker;
    final List<Car> cars;

    public RacingCars(RandomNumberPicker picker, String[] carNames) {
        this.picker = picker;
        this.cars = mapCars(carNames);
    }

    private List<Car> mapCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public void run(Round round) {
        for (Car car : cars) {
            int randomNumber = picker.pick();
            car.run(randomNumber);

            car.record(round);
        }
    }
}
