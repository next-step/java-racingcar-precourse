package racingcar;

import racingcar.service.RacingService;
import racingcar.service.Service;

public class Application {
    public static void main(String[] args) {
        Service service = new RacingService();
        service.start();
    }
}
