package repository;

import domain.RacingCar;
import java.util.List;

public interface RacingCarRepository {

    void save(RacingCar racingCar);

    List<RacingCar> findAll();
}
