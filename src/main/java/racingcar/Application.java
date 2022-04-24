package racingcar;

import racingcar.controller.RacingCarGame;
import racingcar.service.RacingCarService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingCarGame game = new RacingCarGame(new RacingCarService());
        game.startGame();
    }
}
