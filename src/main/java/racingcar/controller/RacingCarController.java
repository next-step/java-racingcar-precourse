package racingcar.controller;

import racingcar.domain.GameCount;
import racingcar.domain.Players;
import racingcar.domain.Race;
import racingcar.domain.RandomMovingStrategy;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;

public class RacingCarController {
    public void playGame() {
        Race race = new Race(getPlayers(),
                getGameCount(),
                new RandomMovingStrategy());
        OutputView.printGameResult();
        while (race.onPlay()) {
            OutputView.printResultPerRace(race.run());
        }
        OutputView.printWinners(race.getWinners());
    }

    private GameCount getGameCount() {
        try {
            return new GameCount(InputView.inputGameCount());
        } catch (IllegalArgumentException e) {
            OutputView.printIllegalArgumentException(e);
            return getGameCount();
        }
    }

    private Players getPlayers() {
        try {
            return new Players(InputView.inputPlayers());
        } catch (IllegalArgumentException e) {
            OutputView.printIllegalArgumentException(e);
            return getPlayers();
        }
    }
}
