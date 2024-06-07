package domain;

import domain.RacingCarModel;
import java.util.List;
import java.util.stream.IntStream;
import repository.RacingCarRepository;
import repository.RacingCarRoundRepository;

public class RacingCarService {

    private final RacingCarRepository racingCarRepository;
    private final RacingCarRoundRepository racingCarRoundRepository;

    public RacingCarService(RacingCarRepository racingCarRepository,
        RacingCarRoundRepository racingCarRoundRepository) {
        this.racingCarRepository = racingCarRepository;
        this.racingCarRoundRepository = racingCarRoundRepository;
    }

    public void createRacingCar(RacingCarCommand.Create create) {
        RacingCar.create(create).forEach(racingCarRepository::save);
    }

    /**
     * round 수 만큼 RacingCar를 이동시킨다. round가 끝날때 마다 round별 RacingCar를 저장한다.
     */
    public void playRacing(RacingCarCommand.RacingRound racingRound) {
        List<RacingCar> racingCars = racingCarRepository.findAll();
        int roundNumber = Integer.parseInt(racingRound.round());
        IntStream.range(0, roundNumber)
            .forEach(round -> {
                racingCars.forEach(RacingCar::move);
                racingCarRoundRepository.save(RacingCarRound.create(round, racingCars));
            });
    }

    public RacingCarModel.GameResult getGameResult() {
        List<RacingCarRound> racingCarRounds = racingCarRoundRepository.findAll();
        return RacingCarModel.GameResult.from(racingCarRounds);
    }

}
