package repository;

import domain.RacingCar;
import domain.RacingCarRound;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarRoundRepositoryImpl implements RacingCarRoundRepository {

    private List<RacingCarRound> racingCarRoundMemory = new ArrayList<>();

    /**
     * 복사후 저장합니다.
     */
    @Override
    public void save(RacingCarRound racingCarRound) {
        racingCarRoundMemory.add(racingCarRound.copy());
    }

    @Override
    public List<RacingCarRound> findAll() {
        return racingCarRoundMemory;
    }

}
