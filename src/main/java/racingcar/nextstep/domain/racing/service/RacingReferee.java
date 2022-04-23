package racingcar.nextstep.domain.racing.service;

import racingcar.nextstep.domain.car.Cars;

public interface RacingReferee {
    Cars findWinners(Cars cars);
}
