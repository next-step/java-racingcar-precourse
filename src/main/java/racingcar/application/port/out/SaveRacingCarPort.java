package racingcar.application.port.out;

import racingcar.domain.RacingCars;

public interface SaveRacingCarPort {
    void save(RacingCars racingCars);
}
