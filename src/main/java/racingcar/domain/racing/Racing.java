package racingcar.domain.racing;

import static racingcar.utils.ValidationUtils.requireNotNull;

import java.util.List;
import racingcar.domain.car.CarMovingStrategy;

public class Racing {
    private final RacingCars racingCars;

    private final RacingTrialCounter racingTrialCounter;

    public Racing(List<String> carNames, int movingTrials, CarMovingStrategy carMovingStrategy) {
        this.racingCars = RacingCars.createdBy(carNames, carMovingStrategy);
        this.racingTrialCounter = new RacingTrialCounter(movingTrials);
    }

    public Racing(RacingCars racingCars, int racingTrials) {
        requireNotNull(racingCars, "The racing cars should not be null!");
        this.racingCars = racingCars;
        this.racingTrialCounter = new RacingTrialCounter(racingTrials);
    }

    public CarStatuses raceOnce() {
        racingTrialCounter.incrementTrialCount();
        return racingCars.moveAll();
    }

    public boolean isFinished() {
        return racingTrialCounter.isReachingTrialLimit();
    }

    private boolean isNotFinished() {
        return !isFinished();
    }

    public CarStatuses getWinners() {
        if (isNotFinished()) {
            throw new IllegalStateException("The racing is not finished!");
        }
        return racingCars.filterHighestDistanceCars();
    }
}
