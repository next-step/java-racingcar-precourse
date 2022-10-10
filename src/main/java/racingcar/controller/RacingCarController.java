package racingcar.controller;

import racingcar.domain.racing.Racing;
import racingcar.domain.racing.random.DefaultRacingRandom;
import racingcar.domain.racing.result.Result;
import racingcar.domain.racing.validation.DefaultRacingValidator;
import racingcar.domain.service.RacingCarService;
import racingcar.view.RacingCarView;

public class RacingCarController {

    RacingCarService service;
    RacingCarView view;

    public RacingCarController(RacingCarService service, RacingCarView view) {
        this.service = service;
        this.view = view;
    }

    public void start() {
        boolean isComplete = false;
        while (!isComplete) {
            isComplete = readCarNamesAndCreateCars();
        }
    }

    public void play() {
        boolean isComplete = false;
        while (!isComplete) {
            isComplete = readTryNoAndMakeResult();
        }
    }

    private boolean readCarNamesAndCreateCars() {
        try {
            service.createCars(view.readLine(RacingCarView.READ_CAR_NAMES));
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    private boolean readTryNoAndMakeResult() {
        try {
            Racing racing = new Racing(view.readLine(RacingCarView.READ_TRY_NO), new DefaultRacingValidator(),
                    new DefaultRacingRandom());
            Result result = racing.result(service.findCars());
            view.printResult(result);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
