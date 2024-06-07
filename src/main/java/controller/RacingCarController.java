package controller;

import controller.RacingCarRequest.CreateCarRequest;
import domain.RacingCarService;

public class RacingCarController {

    private final RacingCarService racingCarService;

    public RacingCarController(RacingCarService racingCarService) {
        this.racingCarService = racingCarService;
    }

    public void createRacingCar(RacingCarRequest.CreateCarRequest createCarRequest) {
        racingCarService.createRacingCar(createCarRequest.toCommand());
    }

    public void startRacing(RacingCarRequest.RacingRoundRequest racingRoundRequest) {

    }
}
