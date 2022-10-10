package racingcar.config;

import racingcar.controller.RacingCarController;
import racingcar.domain.repository.RacingCarRepository;
import racingcar.domain.repository.RacingCarRepositoryImpl;
import racingcar.domain.service.RacingCarService;
import racingcar.domain.service.RacingCarServiceImpl;
import racingcar.view.RacingCarConsoleView;
import racingcar.view.RacingCarView;

public class AppConfig {

    public static RacingCarController racingCarController() {
        return new RacingCarController(racingCarService(), racingCarView());
    }

    private static RacingCarView racingCarView() {
        return new RacingCarConsoleView();
    }

    private static RacingCarService racingCarService() {
        return new RacingCarServiceImpl(racingCarRepository());
    }

    private static RacingCarRepository racingCarRepository() {
        return new RacingCarRepositoryImpl();
    }
}
