package config;

import controller.RacingCarController;
import domain.service.RacingCarService;
import repository.RacingCarRepository;
import repository.RacingCarRepositoryImpl;

/**
 * RacingCarConfig Repository, Service, Controller를 생성하고 연결하는 클래스
 */
public class RacingCarConfig {

    private static final RacingCarRepository racingCarRepository = new RacingCarRepositoryImpl();

    private static final RacingCarService racingCarService = new RacingCarService(
        racingCarRepository);

    private static final RacingCarController racingCarController = new RacingCarController(
        racingCarService);

    public static RacingCarController getRacingCarController() {
        return racingCarController;
    }

}
