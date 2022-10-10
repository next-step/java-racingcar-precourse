package racingcar.service;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCarList;
import racingcar.domain.Winners;
import racingcar.repository.RacingCarRepository;

import java.util.List;

public class RacingCarServiceImpl implements RacingCarService {
    private final RacingCarRepository racingCarRepository;

    public RacingCarServiceImpl(RacingCarRepository racingCarRepository) {
        this.racingCarRepository = racingCarRepository;
    }

    @Override
    public void save(List<RacingCar> carList) {
        racingCarRepository.saveRacingCarList(carList);
    }

    @Override
    public List<RacingCar> race() {
        RacingCarList racingCarList = racingCarRepository.findRacingCarList();
        racingCarList.raceAll();
        return racingCarList.getRacingCarList();
    }

    @Override
    public Winners getWinners() {
        RacingCarList carList = racingCarRepository.findRacingCarList();
        return carList.report();
    }
}
