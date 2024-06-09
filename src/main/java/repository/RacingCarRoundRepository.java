package repository;

import domain.RacingCarRound;
import java.util.List;

public interface RacingCarRoundRepository {

    void save(RacingCarRound racingCarRound);

    List<RacingCarRound> findAll();

}
