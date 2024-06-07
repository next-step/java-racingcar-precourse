package repository;

import domain.RacingCarRound;
import java.util.ArrayList;
import java.util.List;

public class RacingCarRoundRepositoryImpl implements RacingCarRoundRepository {

    private List<RacingCarRound> racingCarRoundMemory = new ArrayList<>();

    @Override
    public void save(RacingCarRound racingCarRound) {
        racingCarRoundMemory.add(racingCarRound);
    }

    @Override
    public List<RacingCarRound> findAll() {
        return racingCarRoundMemory;
    }
}
