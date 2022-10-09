package racingcar.controller;

import racingcar.domain.RaceCount;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingcarController {
    private RacingGame racingGame;
    private RaceCount raceCount;

    public void ready() {
        generateCars();
        generateRaceCount();

        racingGame.play(raceCount.getRaceCount());
        OutputView.printResult(racingGame);
    }

    private void generateCars() {
        while (true) {
            try {
                racingGame = new RacingGame(InputView.getParticipatingCarNames());
                break;
            } catch (IllegalArgumentException illegalArgumentException) {
                OutputView.printMessage(illegalArgumentException.getMessage());
            }
        }
    }

    private void generateRaceCount() {
        while (true) {
            try {
                raceCount = new RaceCount(InputView.getPlayCount());
                break;
            } catch (IllegalArgumentException illegalArgumentException) {
                OutputView.printMessage(illegalArgumentException.getMessage());
            }
        }
    }
}
