package controller;

import service.RacingService;

public class RacingController {
    private final RacingService racingService = new RacingService();


    public void racingController() {
        racingService.raceStart();

    }
}
