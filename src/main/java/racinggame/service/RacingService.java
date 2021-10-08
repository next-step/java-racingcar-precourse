package racinggame.service;

import racinggame.view.OutputView;

public class RacingService {
    private final OutputView outputView;

    public RacingService(OutputView outputView) {
        this.outputView = outputView;
    }

    public RacingService() {
        this.outputView = new OutputView();
    }

    public void raceStart() {

    }
}
