package katecam.racingcar.application.service;

import katecam.racingcar.application.port.in.command.GameTurnPlayUseCase;
import katecam.racingcar.application.port.out.GameLoadPort;
import katecam.racingcar.domain.Game;

public class GameTurnPlayService implements GameTurnPlayUseCase {
    private final GameLoadPort gameLoadPort;

    public GameTurnPlayService(GameLoadPort gameLoadPort) {
        this.gameLoadPort = gameLoadPort;
    }

    @Override
    public void playTurn() {
        Game game = gameLoadPort.getOrThrow();
        game.playTurn();
    }
}
