package racingcar.configuration;

import racingcar.controller.RacingCarController;
import racingcar.repository.MemoryRacingCarRepository;
import racingcar.repository.RacingCarRepository;
import racingcar.service.RacingCarService;
import racingcar.service.RacingCarServiceImpl;
import racingcar.view.ConsoleRacingCarView;
import racingcar.view.RacingCarView;

public class AppConfig {
    public RacingCarController racingCarController() {
        return new RacingCarController(racingCarService(), racingCarView());
    }

    public RacingCarView racingCarView() {
        return new ConsoleRacingCarView();
    }

    public RacingCarService racingCarService() {
        return new RacingCarServiceImpl(racingCarRepository());
    }

    public RacingCarRepository racingCarRepository() {
        return new MemoryRacingCarRepository();
    }
}
