package racingcar.model;


import racingcar.common.SplitUtil;
import racingcar.common.strategy.NumberStrategy;
import racingcar.model.dto.RacingResult;

import java.util.List;

import static racingcar.common.Constants.UP_RACING_MOVE_COUNT;

public class RacingGame {

    private final List<Car> cars;

    private int progressRacingCount = 0;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public List<RacingResult> start(NumberStrategy strategy, int racingCount) {
        while (progressRacingCount != racingCount) {
            new RacingCar(cars).start(strategy);
            progressRacingCount += UP_RACING_MOVE_COUNT;
        }

        return new RacingCar(cars).getResult();
    }
}
