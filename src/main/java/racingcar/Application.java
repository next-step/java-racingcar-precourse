package racingcar;

import racingcar.nextstep.global.config.AppConfig;
import racingcar.nextstep.interfaces.RacingController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        final AppConfig appConfig = new AppConfig();
        final RacingController racingController = appConfig.racingController();
        racingController.game();
    }
}
