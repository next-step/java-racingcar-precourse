package katecam.racingcar.application.port.out;

import katecam.racingcar.domain.Game;

public interface GameRecordPort {
    void save(Game game);
    void delete();
}
