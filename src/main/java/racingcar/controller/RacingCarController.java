package racingcar.controller;

import racingcar.service.RacingCarFacade;

public class RacingCarController {

    private final RacingCarFacade racingCarFacade;

    public RacingCarController(RacingCarFacade racingCarFacade) {
        this.racingCarFacade = racingCarFacade;
    }

    public void racingStart() {
        racingCarFacade.racingStart();
    }

}
