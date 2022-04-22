package racingcar.game.strategy;

import java.util.List;
import racingcar.car.RacingCarName;
import racingcar.car.RacingCars;

public interface RacingCarWinnerFindStrategy {
    List<RacingCarName> pickWinners(RacingCars racingCars);
}
