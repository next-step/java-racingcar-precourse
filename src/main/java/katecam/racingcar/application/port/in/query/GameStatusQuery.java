package katecam.racingcar.application.port.in.query;

import katecam.racingcar.application.dto.query.GameTotalResultRes;
import katecam.racingcar.application.dto.query.GameTurnResultRes;

public interface GameStatusQuery {
    boolean isEnded();
    GameTurnResultRes getTurnResult();
    GameTotalResultRes getTotalResult();
}
