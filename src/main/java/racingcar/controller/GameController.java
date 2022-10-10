package racingcar.controller;

import racingcar.domain.Game;
import racingcar.domain.RoundNumber;
import racingcar.domain.Winner;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    Game game;

    public void initGame() {
        game = new Game();
        setRacingCars();
        setRoundNumber();
        OutputView.printBlankLine();
    }

    private void setRacingCars() {
        try {
            game.setCars(InputView.inputCarNames());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            setRacingCars();
        }
    }

    private void setRoundNumber() {
        try {
            game.setRoundNumber(InputView.inputGameRound());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            setRoundNumber();
        }
    }

    public void playGame() {
        RoundNumber currentRound = new RoundNumber();
        OutputView.printResult();
        while (!game.roundNumber().isFinalRoundNumber(currentRound)) {
            game.startGame();
            OutputView.printCurrentRoundResult(game.cars());
            currentRound.plus();
        }
        OutputView.printWinners(new Winner(game.cars()));
    }
}
