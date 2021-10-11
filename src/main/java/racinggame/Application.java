package racinggame;

import racinggame.controller.RacingGameController;

public class Application {
    public static void main(String[] args) {
        // TODO 자동차 경주 게임 구현
        RacingGameController racingGameController = new RacingGameController();
        racingGameController.gameStart();
    }
}
