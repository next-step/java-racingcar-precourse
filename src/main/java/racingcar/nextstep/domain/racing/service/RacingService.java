package racingcar.nextstep.domain.racing.service;

import racingcar.nextstep.domain.car.Cars;
import racingcar.nextstep.domain.car.CarsName;

public interface RacingService {
    CarsName requestCarsName();

    int requestAttemptsOfNumber();

    void startRacing(Cars cars, int attemptsOfNumber);

    void printRacingResult(Cars cars, int attemptsOfNumber);

    Cars findWinners(Cars cars);

    void printWinners(Cars winnerCars);
}
