package racingcar;

import racingcar.support.DefaultRandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.PrintView;

public class GameService {

    public RacingCars createRacingCars() {
        try {
            String racingCarNames = InputView.getRacingCarNames();
            return new RacingCars(racingCarNames);
        } catch (IllegalArgumentException e) {
            PrintView.printErrorMessage(e.getMessage());
            return createRacingCars();
        }
    }

    public void gameStart(RacingCars racingCars) {
        int gameRound = InputView.getGameRound();
        for (int i = 0; i < gameRound; i++) {
            racingCars.start(new DefaultRandomNumberGenerator());
            PrintView.printGameResult(racingCars);
        }
    }

    public void printWinners(RacingCars racingCars) {
        Winners winners = new Winners(racingCars.getRacingCars());
        PrintView.printWinnerNames(winners.getWinnerNames());
    }
}
