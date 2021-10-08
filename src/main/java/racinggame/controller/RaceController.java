package racinggame.controller;

import racinggame.service.RacingService;
import racinggame.view.InputView;

public class RaceController {
    private final InputView inputView;

    public RaceController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        while (true) {
            new RacingService().raceStart();
        }
    }

}
