package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Round;
import racingcar.service.RacingCarGame;

public class Application {
    public static void main(String[] args) {
        new RacingCarGame(new Car().getCarNames(), new Round().getRoundNum());
    }
}
