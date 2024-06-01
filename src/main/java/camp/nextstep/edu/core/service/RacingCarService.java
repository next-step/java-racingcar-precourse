package camp.nextstep.edu.core.service;

import camp.nextstep.edu.core.Car;
import camp.nextstep.edu.core.RacingLog;
import camp.nextstep.edu.core.RacingResult;
import camp.nextstep.edu.core.repository.RacingCarRepository;

import java.security.SecureRandom;
import java.util.LinkedList;
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

    public RacingResult runCarRacing(int round) {
        List<RacingLog> racingLogs = new LinkedList<>();
        for (int i = 0; i < round; i++) {
            racingCarRepository.findAll().forEach(this::randomMove);
            racingLogs.add(RacingLog.of(racingCarRepository.findAll()));
        }
        return new RacingResult(List.of(), List.of());
    }

    public void randomMove(Car car) {
        int randomNumber = secureRandom.nextInt(10);
        if (randomNumber >= 4) {
            car.move();
        }
    }
}
