package racingcar.model.racing.random;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.racing.RacingStrategy;
import racingcar.model.racing.RacingStatus;

public class RandomRacingStrategy implements RacingStrategy {
    private final int startRandomNumber;
    private final int endRandomNumber;
    private final int greaterThanOrEqualToStandardNumber;

    public RandomRacingStrategy(int startRandomNumber, int endRandomNumber, int greaterThanOrEqualToStandardNumber) {
        this.startRandomNumber = startRandomNumber;
        this.endRandomNumber = endRandomNumber;
        this.greaterThanOrEqualToStandardNumber = greaterThanOrEqualToStandardNumber;
    }

    @Override
    public RacingStatus race() {
        int randomNumber = pickRandomNumber();

        return race(randomNumber);
    }

    RacingStatus race(int randomNumber) {
        if (randomNumber >= greaterThanOrEqualToStandardNumber) {
            return RacingStatus.GO;
        }
        return RacingStatus.STOP;
    }

    int pickRandomNumber() {
        return Randoms.pickNumberInRange(startRandomNumber, endRandomNumber);
    }
}
