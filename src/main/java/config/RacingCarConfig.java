package config;

import controller.RacingCarController;
import controller.RacingCarFrontController;
import domain.RacingCarService;
import repository.RacingCarRepository;
import repository.RacingCarRepositoryImpl;
import repository.RacingCarRoundRepository;
import repository.RacingCarRoundRepositoryImpl;
import view.InputView;
import view.OutputView;

/**
 * RacingCarConfig Repository, Service, Controller를 생성하고 연결하는 클래스
 */
public class RacingCarConfig {

    private static final OutputView outputView = new OutputView();

    private static final RacingCarRepository racingCarRepository = new RacingCarRepositoryImpl();
    private static final RacingCarRoundRepository racingCarRoundRepository = new RacingCarRoundRepositoryImpl();

    private static final RacingCarService racingCarService = new RacingCarService(
        racingCarRepository, racingCarRoundRepository);

    private static final RacingCarController racingCarController = new RacingCarController(
        racingCarService);
    private static final RacingCarFrontController racingCarFrontController = new RacingCarFrontController(
        racingCarController, outputView);

    public static RacingCarFrontController getRacingCarFrontController() {
        return racingCarFrontController;
    }

}
