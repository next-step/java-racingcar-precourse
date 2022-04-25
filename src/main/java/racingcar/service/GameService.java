package racingcar.service;

import racingcar.domain.Cars;
import racingcar.domain.Game;
import racingcar.ui.Output;

public class GameService {
    private final Game game;

    public GameService(Game game) {
        this.game = game;
    }

    public void playGame(Game game) {
        Cars cars = game.getCars();
        cars.moveCars();
        Output.printInterimResult(cars);
    }
}
