package katecam.racingcar.application.service.command;

import katecam.racingcar.application.dto.command.GameInitializationReq;
import katecam.racingcar.application.port.in.command.GameInitializationUseCase;
import katecam.racingcar.application.port.out.GameLoadPort;
import katecam.racingcar.domain.Game;

public class GameInitializationService implements GameInitializationUseCase {
    private final GameLoadPort gameLoadPort;

    public GameInitializationService(GameLoadPort gameLoadPort) {
        this.gameLoadPort = gameLoadPort;
    }

    @Override
    public void initialize(GameInitializationReq req) {
        Game game = new Game(req.carNames(), req.numberToAttempt());
        gameLoadPort.save(game);
    }
}
