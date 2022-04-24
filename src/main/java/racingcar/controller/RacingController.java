package racingcar.controller;

import racingcar.domain.cars.Cars;
import racingcar.domain.race.RaceTime;
import racingcar.impl.RacingServiceImpl;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;
    private RacingService racingService;

    public RacingController() {

        inputView = new InputView();
        outputView = new OutputView();
    }

    public void raceStart() {
        try {
            racingService = new RacingServiceImpl(inputCars(), inputRaceTime());
            racingService.start();
        } catch (IllegalArgumentException e) {
            outputView.error(e);
            raceStart();
        }
    }

    public RaceTime inputRaceTime() {
        try {
            return RaceTime.of(inputView.inputTimes());
        } catch (IllegalArgumentException e) {
            outputView.error(e);
            return inputRaceTime();
        }
    }

    public Cars inputCars() {
        try {
            return Cars.of(inputView.inputCars());
        } catch (IllegalArgumentException e) {
            outputView.error(e);
            return inputCars();
        }
    }
}
