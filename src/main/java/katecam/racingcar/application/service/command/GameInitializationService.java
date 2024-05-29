package katecam.racingcar.application.service.command;

import katecam.racingcar.application.dto.command.GameInitializationReq;
import katecam.racingcar.application.port.in.command.GameInitializationUseCase;
import katecam.racingcar.application.port.out.GameRepository;
import katecam.racingcar.domain.Game;

public class GameInitializationService implements GameInitializationUseCase {
    private final GameRepository gameRepository;

    public GameInitializationService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public void initialize(GameInitializationReq req) {
        Game game = new Game(req.carNames(), req.numberToAttempt());
        gameRepository.save(game);
    }
}
