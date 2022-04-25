package racingcar.controller;

import racingcar.model.car.generator.LapsGenerator;
import racingcar.model.car.generator.RacingCarsGenerator;
import racingcar.model.car.RacingCars;
import racingcar.model.record.Records;
import racingcar.view.Display;

public class Racing {

    public void start() {
        raceFor(racingCars(), laps());
    }

    private RacingCars racingCars() {
        return RacingCarsGenerator.generate();
    }

    private Laps laps() {
        return LapsGenerator.generate();
    }

    private void raceFor(RacingCars cars, Laps laps) {
        while (laps.hasNext()) {
            laps.lapCountDown();
            cars.race();
            displayEachLaps(cars.records());
        }

        displayFinalRank(cars.records());
    }

    private void displayEachLaps(Records records) {
        Display.printEachLapsReport(records);
    }

    private void displayFinalRank(Records records) {
        Display.printFinalRank(records);
    }
}
