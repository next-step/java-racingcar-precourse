package racingcar;

import racingcar.controller.RacingCarGame;
import racingcar.service.RacingCarService;
import racingcar.utils.RacingConsole;

public class Application {
    public static void main(String[] args) {
        RacingCarGame racingCarGame = new RacingCarGame(new RacingCarService(), new RacingConsole());
        racingCarGame.startGame();

    }
}
