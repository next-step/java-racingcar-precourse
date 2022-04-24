package racingcar.controller;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarName;
import racingcar.domain.car.Cars;
import racingcar.domain.Moving;
import racingcar.domain.game.Game;
import racingcar.domain.game.Round;
import racingcar.domain.number.NumberGenerator;
import racingcar.view.PlayerInputView;
import racingcar.view.ResultView;

public class GameController {
    private final PlayerInputView playerInputView;
    private final ResultView resultView;
    private final NumberGenerator numberGenerator;

    public GameController(PlayerInputView playerInputView, ResultView resultView, NumberGenerator numberGenerator) {
        this.playerInputView = playerInputView;
        this.resultView = resultView;
        this.numberGenerator = numberGenerator;
    }

    public void exec() {
        List<CarName> names = this.playerInputView.waitForCarNameInput();
        Cars cars = Cars.of(names, Moving.by(this.numberGenerator));
        Round userDefinedRound = this.playerInputView.waitForRoundInput();
        Game game = Game.of(cars);

        play(game, userDefinedRound);
        announceWinner(game);
    }

    private void play(Game game, Round round) {
        this.resultView.printResult();
        while (!game.getRound().equals(round)) {
            game.play();
            this.resultView.printRound(game.getCars());
        }
    }

    private void announceWinner(Game game) {
        List<Car> winners = game.findMostMovedCars();
        this.resultView.printWinners(winners);
    }
}
