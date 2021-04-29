package camp.nextstep.edu;

import camp.nextstep.edu.game.Game;
import camp.nextstep.edu.game.RacingGame;

public class GameMain {

    public static void main(String[] args) {
        Game game = new RacingGame();
        game.start();
    }
}
