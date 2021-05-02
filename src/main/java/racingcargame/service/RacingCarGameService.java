package racingcargame.service;

import racingcargame.domain.RacingCars;

public class RacingCarGameService {
    RacingCars racingCars;

    public void makeCars(String carNames) {
        racingCars = RacingCars.makeCars(carNames);
    }
}
