package racingcar;

import racingcar.car.external.RandomCarMovePolicyStrategyImpl;
import racingcar.car.service.RacingCarGameService;

public class Application {
    public static void main(String[] args) {
        RacingCarGameService gameService = new RacingCarGameService(new RandomCarMovePolicyStrategyImpl());
        gameService.play();
    }
}
