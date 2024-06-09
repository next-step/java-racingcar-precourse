package racingcar.application.port.in;

import racingcar.application.port.RacingCarResultResponse;

public interface RacingCarPlayUseCase {
    RacingCarResultResponse play(final int number, final String... names);
}
