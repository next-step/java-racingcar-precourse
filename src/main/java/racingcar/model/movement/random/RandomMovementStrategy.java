package racingcar.model.movement.random;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.movement.MovementStrategy;
import racingcar.model.movement.MovementStatus;

public class RandomMovementStrategy implements MovementStrategy {
    private final int startRandomNumber;
    private final int endRandomNumber;
    private final int greaterThanOrEqualToStandardNumber;

    public RandomMovementStrategy(int startRandomNumber, int endRandomNumber, int greaterThanOrEqualToStandardNumber) {
        this.startRandomNumber = startRandomNumber;
        this.endRandomNumber = endRandomNumber;
        this.greaterThanOrEqualToStandardNumber = greaterThanOrEqualToStandardNumber;
    }

    @Override
    public MovementStatus race() {
        int randomNumber = pickRandomNumber();

        return race(randomNumber);
    }

    MovementStatus race(int randomNumber) {
        if (randomNumber >= greaterThanOrEqualToStandardNumber) {
            return MovementStatus.GO;
        }
        return MovementStatus.STOP;
    }

    int pickRandomNumber() {
        return Randoms.pickNumberInRange(startRandomNumber, endRandomNumber);
    }
}
