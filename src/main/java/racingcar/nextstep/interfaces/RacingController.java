package racingcar.nextstep.interfaces;

import racingcar.nextstep.domain.car.Cars;
import racingcar.nextstep.domain.car.CarsName;
import racingcar.nextstep.domain.car.service.CarService;
import racingcar.nextstep.domain.racing.service.RacingService;

public class RacingController {

    private final CarService carService;
    private final RacingService racingService;

    public RacingController(CarService carService, RacingService racingService) {
        this.carService = carService;
        this.racingService = racingService;
    }

    public void game() {
        final CarsName carsName = racingService.requestCarsName();
        final Cars cars = carService.createCars(carsName);
        final int attemptsOfNumber = racingService.requestAttemptsOfNumber();

        racingService.startRacing(cars, attemptsOfNumber);
        racingService.printRacingResult(cars, attemptsOfNumber);
        final Cars winnerCars = racingService.findWinners(cars);
        racingService.printWinners(winnerCars);
    }
}
