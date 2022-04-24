package racingcar;

import racingcar.domain.RacingCar;
import racingcar.service.RacingCarService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        new RacingCarService().start();
    }
}
