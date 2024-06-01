package camp.nextstep.edu.core.service;

import camp.nextstep.edu.core.Car;
import camp.nextstep.edu.core.repository.RacingCarRepository;

import java.security.SecureRandom;
import java.util.List;

public class RacingCarService {
    private final SecureRandom secureRandom = new SecureRandom();
    private final RacingCarRepository racingCarRepository;

    public RacingCarService(RacingCarRepository racingCarRepository) {
        this.racingCarRepository = racingCarRepository;
    }

    public void registerCars(List<Car> cars) {
        racingCarRepository.save(cars);
    }
}
