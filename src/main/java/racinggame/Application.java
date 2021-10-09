package racinggame;

import racinggame.controller.RacingGame;
import racinggame.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO 자동차 경주 게임 구현
        RacingGame game = new RacingGame(new InputView());
        game.play();
    }
}
