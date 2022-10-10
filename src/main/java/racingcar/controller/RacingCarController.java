package racingcar.controller;

import racingcar.domain.car.Cars;
import racingcar.domain.fuel.FuelGenerator;
import racingcar.view.RacingCarInput;
import racingcar.view.RacingCarView;

public class RacingCarController {
    private final FuelGenerator fuelGenerator;
    private final RacingCarInput racingCarInput;
    private final RacingCarView racingCarView;

    public RacingCarController(FuelGenerator fuelGenerator,
                               RacingCarInput racingCarInput,
                               RacingCarView racingCarView) {
        this.fuelGenerator = fuelGenerator;
        this.racingCarInput = racingCarInput;
        this.racingCarView = racingCarView;
    }

    public void play() {
        Cars cars = racingCarInput.getCars();
        int tryCount = racingCarInput.getTryCount();

        play(cars, tryCount);
        racingCarView.printWinners(cars);
    }

    private void play(Cars cars, int tryCount) {
        racingCarView.printStepResultGuide();

        for (int step = 1; step <= tryCount; step++) {
            cars.move(fuelGenerator);
            racingCarView.printStepResult(cars);
        }
    }
}
