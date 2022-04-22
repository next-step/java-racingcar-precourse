package racingcar.model.racing;

import racingcar.model.car.Car;
import racingcar.model.car.CarNameSplitter;
import racingcar.model.car.CarEntries;
import racingcar.model.lap.LapCount;

import java.util.ArrayList;
import java.util.List;

public class RacingBuilder {
    private CarEntries carEntries;
    private LapCount lapCount;

    RacingBuilder() {
    }

    public RacingBuilder carNames(String carNamesWithComma) {
        this.carEntries = makeCarEntries(carNamesWithComma);
        return this;
    }

    private CarEntries makeCarEntries(String carNamesWithComma) {
        List<Car> cars = convertCars(carNamesWithComma);

        return new CarEntries(cars);
    }

    private List<Car> convertCars(String carNamesWithComma) {
        List<Car> createCars = new ArrayList<>();

        String[] carNames = CarNameSplitter.split(carNamesWithComma);
        for (String carName : carNames) {
            createCars.add(new Car(carName));
        }

        return createCars;
    }

    public RacingBuilder lapCount(String lapCount) {
        this.lapCount = new LapCount(lapCount);
        return this;
    }

    public Racing build() {
        return new Racing(this.carEntries, this.lapCount);
    }
}
