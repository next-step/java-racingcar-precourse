package racingcar;

import racingcar.game.RacingGame;
import racingcar.view.RacingGameView;
import racingcar.view.RacingGameViewWithNsConsole;

public class Application {
    public static void main(String[] args) {
        RacingGameView view = new RacingGameViewWithNsConsole();
        RacingGame game = new RacingGame(view);
        game.start();
    }
}
