package repository;

import domain.RacingCar;
import domain.RacingCarRound;
import java.util.ArrayList;
import java.util.List;

public class RacingCarRepositoryImpl implements RacingCarRepository {

    private List<RacingCar> racingCarMemory = new ArrayList<>();

    @Override
    public void save(RacingCar racingCar) {
        racingCarMemory.add(racingCar);
    }

    @Override
    public List<RacingCar> findAll() {
        return racingCarMemory;
    }
}
