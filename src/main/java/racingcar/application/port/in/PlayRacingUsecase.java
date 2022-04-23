package racingcar.application.port.in;

import racingcar.domain.RacingResult;

public interface PlayRacingUsecase {
    RacingResult playRacing(PlayRacingCommand command);
}
