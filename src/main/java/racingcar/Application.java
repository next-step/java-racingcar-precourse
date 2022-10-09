package racingcar;

import racingcar.game.CarRacingGame;
import racingcar.game.Game;
import racingcar.move.RandomMovement;

public class Application {
    public static void main(String[] args) {
        Game game = new CarRacingGame(new RandomMovement());
        GameManager gameManager = new GameManager(game);
        gameManager.run();
    }
}
