package racingcar;

import racingcar.controller.Game;
import racingcar.view.GameView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameView gameView = new GameView();
        new Game(gameView).play();
    }
}
