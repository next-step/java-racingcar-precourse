package katecam.racingcar.application.service.command;

import katecam.racingcar.application.port.in.command.GameTurnPlayUseCase;
import katecam.racingcar.application.port.out.GameRepository;
import katecam.racingcar.domain.Game;

public class GameTurnPlayService implements GameTurnPlayUseCase {
    private final GameRepository gameRepository;

    public GameTurnPlayService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }
    @Override
    public void playTurn() {
        Game game = gameRepository.getOrThrow();
        game.playTurn();
    }
}
