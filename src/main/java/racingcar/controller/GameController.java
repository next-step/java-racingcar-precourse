package racingcar.controller;

import racingcar.RacingCarConstants;
import racingcar.View.InputView;
import racingcar.View.OutputView;
import racingcar.model.Game;
import racingcar.model.GameStatus;
import racingcar.model.rule.CarMoveRule;
import racingcar.model.rule.PlayCountRule;

public class GameController {
    Game game;

    public void initGame() {
        CarMoveRule carMoveRule = new CarMoveRule(
                RacingCarConstants.CAR_MOVE_RULE_MOVE_SIZE,
                RacingCarConstants.CAR_MOVE_RULE_STOP_SIZE,
                RacingCarConstants.CAR_MOVE_RULE_MOVE_MIN_CONDITION,
                RacingCarConstants.CAR_MOVE_PRINT_WORD);
        PlayCountRule playCountRule = new PlayCountRule(
                RacingCarConstants.PLAY_COUNT_MIN_SIZE,
                RacingCarConstants.PLAY_COUNT_MAX_SIZE
        );
        game = new Game(carMoveRule, playCountRule);
        startGame();
    }

    public void startGame() {
        game.setGameStatus(GameStatus.START);
        setRacingCars();
        setPlayCount();
        while (!game.getGameStatus().isEndGame()) {
            playGame();
        }
    }

    private void setRacingCars() {
        try {
            game.setRacingCars(InputView.inputRacingCarNames());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            setRacingCars();
        }
    }

    private void setPlayCount() {
        try {
            game.setPlayCount(InputView.inputNumber());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            setPlayCount();
        }
    }

    private void playGame() {
        game.playGame();
        OutputView.printResult(game.getCurrentResult());
        OutputView.printWinners(game.getWinnersResult());
        game.setGameStatus(GameStatus.END);
    }
}
