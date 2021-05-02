package racingcargame;

import racingcargame.controller.RacingCarGameController;
import racingcargame.service.RacingCarGameService;

public class RacingCarGame {
    public static void main(String[] args) {
        RacingCarGameService racingCarGameService = new RacingCarGameService();
        new RacingCarGameController(racingCarGameService).run();
    }
}
