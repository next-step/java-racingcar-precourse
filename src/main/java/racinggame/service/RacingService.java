package racinggame.service;

import racinggame.model.RacingCars;
import racinggame.view.OutputView;

public class RacingService {
    private final RacingCars racingCars;

    public RacingService(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    public void playRounds(int round) {
        OutputView outputView = new OutputView();
        outputView.displayExecutionResult();
        for (int i = 0; i < round; i++) {
            outputView.displayResults(racingCars.proceedRace());
        }
        outputView.displayResults(racingCars.getWinner());
    }
}
