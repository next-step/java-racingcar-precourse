package repository;

import domain.RacingCar;
import java.util.List;

public class RacingCarRepositoryImpl implements RacingCarRepository {

    List<RacingCar> racingCarMemory;

    @Override
    public List<RacingCar> save(RacingCar racingCar) {
        racingCarMemory.add(racingCar);
        return racingCarMemory;
    }
}
