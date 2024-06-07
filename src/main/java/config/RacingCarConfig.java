package config;

import controller.RacingCarController;
import domain.RacingCarService;
import repository.RacingCarRepository;
import repository.RacingCarRepositoryImpl;
import repository.RacingCarRoundRepository;
import repository.RacingCarRoundRepositoryImpl;

/**
 * RacingCarConfig Repository, Service, Controller를 생성하고 연결하는 클래스
 */
public class RacingCarConfig {

    private static final RacingCarRepository racingCarRepository = new RacingCarRepositoryImpl();
    private static final RacingCarRoundRepository racingCarRoundRepository = new RacingCarRoundRepositoryImpl();

    private static final RacingCarService racingCarService = new RacingCarService(
        racingCarRepository, racingCarRoundRepository);

    private static final RacingCarController racingCarController = new RacingCarController(
        racingCarService);

    public static RacingCarController getRacingCarController() {
        return racingCarController;
    }

}
