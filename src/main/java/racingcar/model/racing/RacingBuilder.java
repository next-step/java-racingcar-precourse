package racingcar.model.racing;

import racingcar.model.car.Car;
import racingcar.model.car.CarNameSplitter;
import racingcar.model.car.Entries;

import java.util.ArrayList;
import java.util.List;

public class RacingBuilder {
    private Entries entries;
    private LapCount lapCount;

    RacingBuilder() {
    }

    public RacingBuilder carNames(String carNamesWithComma) {
        this.entries = createEntries(carNamesWithComma);
        return this;
    }

    private Entries createEntries(String carNamesWithComma) {
        List<Car> cars = convertCars(carNamesWithComma);

        return new Entries(cars);
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
        return new Racing(this.entries, this.lapCount);
    }
}
