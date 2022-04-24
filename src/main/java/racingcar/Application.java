package racingcar;

import racingcar.service.RacingCarGameService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingCarGameService racingCarGameService = new RacingCarGameService();
        racingCarGameService.startRacingGame();
    }
}
