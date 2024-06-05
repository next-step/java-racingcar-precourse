package katecam.racingcar.application.service.command;

import katecam.racingcar.application.dto.command.GameInitializationReq;
import katecam.racingcar.application.port.in.command.GameInitializationUseCase;
import katecam.racingcar.application.port.out.GameRecordPort;
import katecam.racingcar.domain.Game;

public class GameInitializationService implements GameInitializationUseCase {
    private final GameRecordPort gameRecordPort;

    public GameInitializationService(GameRecordPort gameRecordPort) {
        this.gameRecordPort = gameRecordPort;
    }

    @Override
    public void initialize(GameInitializationReq req) {
        Game game = new Game(req.carNames(), req.numberToAttempt());
        gameRecordPort.save(game);
    }
}
