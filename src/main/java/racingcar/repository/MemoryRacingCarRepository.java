package racingcar.repository;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCarList;

import java.util.List;

public class MemoryRacingCarRepository implements RacingCarRepository {
    private RacingCarList racingCarList;

    @Override
    public void saveRacingCarList(List<RacingCar> carList) {
        this.racingCarList = new RacingCarList(carList);
    }

    @Override
    public RacingCarList findRacingCarList() {
        return this.racingCarList;
    }

    @Override
    public void clear() {
        this.racingCarList = null;
    }
}
