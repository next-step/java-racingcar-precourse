package racingcar;

import racingcar.game.Game;

public class GameManager {

    private final Game game;

    public GameManager(Game game) {
        this.game = game;
    }

    public void run() {
        game.ready();
        game.start();
        game.finish();
    }
}
