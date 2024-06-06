package domain.service;

import repository.RacingCarRepository;

public class RacingCarService {

    private final RacingCarRepository racingCarRepository;

    public RacingCarService(RacingCarRepository racingCarRepository) {
        this.racingCarRepository = racingCarRepository;
    }
}
