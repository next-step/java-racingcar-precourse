package racinggame;

import racinggame.controller.RacingGameController;
import racinggame.view.RacingGameView;

public class Application {
    public static void main(String[] args) {
        RacingGameController racingGameController = new RacingGameController();
        RacingGameView racingGameView = new RacingGameView(racingGameController);
        racingGameView.start();
    }
}
