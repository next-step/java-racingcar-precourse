package katecam.config;

import katecam.racingcar.adapter.in.RacingCarController;
import katecam.racingcar.adapter.out.InMemoryGameAdaptor;
import katecam.racingcar.application.port.in.command.GameInitializationUseCase;
import katecam.racingcar.application.port.in.command.GameTurnPlayUseCase;
import katecam.racingcar.application.port.in.query.GameStatusQuery;
import katecam.racingcar.application.port.out.GameRecordPort;
import katecam.racingcar.application.port.out.GameLoadPort;
import katecam.racingcar.application.service.GameInitializationService;
import katecam.racingcar.application.service.GameTurnPlayService;
import katecam.racingcar.application.service.GameStatusQueryService;

public class AppConfig {
    private static GameLoadPort gameLoadPort;
    private static GameRecordPort gameRecordPort;
    private static GameInitializationUseCase gameInitializationUseCase;
    private static GameTurnPlayUseCase gameTurnPlayUseCase;
    private static GameStatusQuery gameStatusQuery;
    private static RacingCarController racingCarController;

    static {
        InMemoryGameAdaptor inMemoryGameAdaptor = new InMemoryGameAdaptor();
        gameRecordPort = inMemoryGameAdaptor;
        gameLoadPort = inMemoryGameAdaptor;
        gameInitializationUseCase = new GameInitializationService(gameRecordPort);
        gameTurnPlayUseCase = new GameTurnPlayService(gameLoadPort);
        gameStatusQuery = new GameStatusQueryService(gameLoadPort);
        racingCarController = new RacingCarController(
                gameInitializationUseCase,
                gameTurnPlayUseCase,
                gameStatusQuery
        );
    }

    public static RacingCarController getRacingCarController() {
        return racingCarController;
    }
}