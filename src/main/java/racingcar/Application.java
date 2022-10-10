package racingcar;

import racingcar.control.Game;
import racingcar.control.RacingCarGame;
import racingcar.view.ConsoleGameView;

public class Application {
    public static void main(String[] args) {
        Game racingCarGame = new RacingCarGame(new ConsoleGameView());
        racingCarGame.init();
        racingCarGame.start();
    }
}
