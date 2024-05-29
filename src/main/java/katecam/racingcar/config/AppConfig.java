package katecam.racingcar.config;

import katecam.RacingCarView;
import katecam.racingcar.adaptor.in.RacingCarController;
import katecam.racingcar.adaptor.out.InMemoryGameRepository;
import katecam.racingcar.application.port.in.command.GameInitializationUseCase;
import katecam.racingcar.application.port.in.command.GameTurnPlayUseCase;
import katecam.racingcar.application.port.in.query.GameStatusQuery;
import katecam.racingcar.application.port.out.GameRepository;
import katecam.racingcar.application.service.command.GameInitializationService;
import katecam.racingcar.application.service.command.GameTurnPlayService;
import katecam.racingcar.application.service.query.GameStatusQueryService;

public class AppConfig {
    private static GameRepository gameRepository;
    private static GameInitializationUseCase gameInitializationUseCase;
    private static GameTurnPlayUseCase gameTurnPlayUseCase;
    private static GameStatusQuery gameStatusQuery;
    private static RacingCarController racingCarController;
    private static RacingCarView racingCarView;

    static {
        gameRepository = new InMemoryGameRepository();
        gameInitializationUseCase = new GameInitializationService(gameRepository);
        gameTurnPlayUseCase = new GameTurnPlayService(gameRepository);
        gameStatusQuery = new GameStatusQueryService(gameRepository);
        racingCarController = new RacingCarController(
                gameInitializationUseCase,
                gameTurnPlayUseCase,
                gameStatusQuery
        );
        racingCarView = new RacingCarView();
    }

    public static RacingCarController getRacingCarController() {
        return racingCarController;
    }

    public static RacingCarView getRacingCarView() {
        return racingCarView;
    }
}