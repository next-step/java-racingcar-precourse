package racinggame;

import racinggame.controller.RacingGame;
import racinggame.view.InputView;
import racinggame.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO 자동차 경주 게임 구현
        RacingGame racingGame = new RacingGame(new InputView(), new OutputView());
        racingGame.play();
    }
}
