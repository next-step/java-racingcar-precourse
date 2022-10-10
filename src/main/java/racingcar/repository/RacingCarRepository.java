package racingcar.repository;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCarList;

import java.util.List;

public interface RacingCarRepository {
    void saveRacingCarList(List<RacingCar> carList);

    RacingCarList findRacingCarList();

    void clear();
}
