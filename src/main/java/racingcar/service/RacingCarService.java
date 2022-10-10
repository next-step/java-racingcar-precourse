package racingcar.service;

import racingcar.domain.RacingCar;
import racingcar.domain.Winners;

import java.util.List;

public interface RacingCarService {
    void save(List<RacingCar> racingCarNames);

    List<RacingCar> race();

    Winners getWinners();
}
