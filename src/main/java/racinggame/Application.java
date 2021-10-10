package racinggame;

import racinggame.controller.RacingGameController;
import racinggame.service.RaceService;

public class Application {
    public static void main(String[] args) {
        // TODO 자동차 경주 게임 구현
        final RacingGameController racingGameController = new RacingGameController(new RaceService());
        racingGameController.gameStart();
    }
}
