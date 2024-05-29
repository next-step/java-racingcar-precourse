package race.controller;

import race.view.InputView;
import race.view.OutputView;

public class RaceController {
    private final InputView inputView;
    private final OutputView outputView;

    public RaceController() {
        this.inputView = InputView.getInstance();
        this.outputView = OutputView.getInstance();
    }

    public void startRace() {}

    public void initializeRace() {}

    public void proceedStep() {}
}
