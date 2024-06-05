package katecam.config;

import katecam.racingcar.adaptor.in.RacingCarController;
import katecam.racingcar.adaptor.out.InMemoryGameAdaptor;
import katecam.racingcar.application.port.in.command.GameInitializationUseCase;
import katecam.racingcar.application.port.in.command.GameTurnPlayUseCase;
import katecam.racingcar.application.port.in.query.GameStatusQuery;
import katecam.racingcar.application.port.out.GameRecordPort;
import katecam.racingcar.application.port.out.GameLoadPort;
import katecam.racingcar.application.service.command.GameInitializationService;
import katecam.racingcar.application.service.command.GameTurnPlayService;
import katecam.racingcar.application.service.query.GameStatusQueryService;

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