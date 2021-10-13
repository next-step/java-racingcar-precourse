package racinggame.ui;

import racinggame.domain.Names;
import racinggame.domain.NumberOfMoves;
import racinggame.domain.RacingCars;

public class RacingGameDriver {

    public void play() {
        RacingCars c = new RacingCars(readNames());
        c.race(readNumberOfMoves());
    }

    private Names readNames() {
        return InputView.getRacingCarNamesWithRetry();
    }

    private NumberOfMoves readNumberOfMoves() {
        return InputView.getNumberOfMovesWithRetry();
    }
}
