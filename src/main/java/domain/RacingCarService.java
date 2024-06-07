package domain;

import domain.RacingCarCommand;
import repository.RacingCarRepository;

public class RacingCarService {

    private final RacingCarRepository racingCarRepository;

    public RacingCarService(RacingCarRepository racingCarRepository) {
        this.racingCarRepository = racingCarRepository;
    }

    public void createRacingCar(RacingCarCommand.Create create) {
        RacingCar.create(create).forEach(racingCarRepository::save);
    }

    
}
