package racingcar.controller;

import racingcar.domain.racing.Racing;
import racingcar.domain.racing.RacingResult;
import racingcar.domain.racing.TryCount;
import racingcar.domain.racing.racer.Winner;
import racingcar.dto.response.RacingTryResult;
import racingcar.dto.response.WinnerNames;
import racingcar.view.RacingCarGameView;

public class RacingCarGameController {
    private final RacingCarGameView racingCarGameView;

    public RacingCarGameController(RacingCarGameView racingCarGameView) {
        this.racingCarGameView = racingCarGameView;
    }

    public void startGame() {
        RacingResult result = startRacing();
        showTryResults(result);
        showWinner(result.getWinner());
    }

    private void showTryResults(RacingResult result) {
        racingCarGameView.showResult();
        result.getHistory().get().forEach(cars -> racingCarGameView.showTryResult(RacingTryResult.from(cars)));
    }

    private void showWinner(Winner winner) {
        racingCarGameView.showWinners(WinnerNames.from(winner));
    }

    private RacingResult startRacing() {
        Racing racing = createRacing();
        return racing.start(getTryCount());
    }

    private Racing createRacing() {
        try {
            return Racing.from(racingCarGameView.getCarNames().get());
        } catch (IllegalArgumentException ex) {
            showError(ex.getMessage());
            return createRacing();
        }
    }

    private TryCount getTryCount() {
        try {
            return TryCount.from(racingCarGameView.getTryCount().get());
        } catch (IllegalArgumentException ex) {
            showError(ex.getMessage());
            return getTryCount();
        }
    }

    private void showError(String error) {
        racingCarGameView.showError(error);
    }
}
