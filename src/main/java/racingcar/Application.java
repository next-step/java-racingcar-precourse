package racingcar;

import racingcar.service.RacingGameService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingGameService racingGame = new RacingGameService();
        racingGame.run();
    }
}
