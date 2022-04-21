package racingcar.model.car;

import racingcar.model.racing.RacingStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Entries {
    private final List<Car> cars;

    public Entries(List<Car> cars) {
        this.cars = cars;
    }

    public void race(RacingStrategy racingStrategy) {
        for (Car car : cars) {
            car.race(racingStrategy);
        }
    }

    public List<CarDto> convertCarDto() {
        int maxPosition = getMaxPosition();

        List<CarDto> carDtoList = new ArrayList<>();
        for (Car car : cars) {
            carDtoList.add(car.convertCarDto(maxPosition));
        }

        return carDtoList;
    }

    private int getMaxPosition() {
        Car maxPositionCar = Collections.max(cars);
        return maxPositionCar.getPosition();
    }
}
