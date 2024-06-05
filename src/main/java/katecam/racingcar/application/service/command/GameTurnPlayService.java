package katecam.racingcar.application.service.command;

import katecam.racingcar.application.port.in.command.GameTurnPlayUseCase;
import katecam.racingcar.application.port.out.GameRecordPort;
import katecam.racingcar.domain.Game;

public class GameTurnPlayService implements GameTurnPlayUseCase {
    private final GameRecordPort gameRecordPort;

    public GameTurnPlayService(GameRecordPort gameRecordPort) {
        this.gameRecordPort = gameRecordPort;
    }

    @Override
    public void playTurn() {
        Game game = gameRecordPort.getOrThrow();
        game.playTurn();
    }
}
