package repository;

import domain.RacingCar;
import java.util.List;

public interface RacingCarRepository {

    List<RacingCar> save(RacingCar racingCar);
}
