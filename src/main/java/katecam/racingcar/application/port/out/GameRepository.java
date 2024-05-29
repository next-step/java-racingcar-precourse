package katecam.racingcar.application.port.out;

import katecam.racingcar.domain.Game;

public interface GameRepository {
    void save(Game game);
    Game getOrThrow();
    void delete();
}
