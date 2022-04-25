package racingcar.model.car;

import java.util.List;
import racingcar.model.record.Records;

public class RacingCars {
    private final List<RacingCar> racingCars;

    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public void race() {
        for (RacingCar racingCar : racingCars) {
            racingCar.race();
        }
    }

    public Records records() {
        Records records = new Records();
        for (RacingCar racingCar : racingCars) {
            records.addRecord(racingCar.record());
        }

        return records;
    }
}
