package racingcar.domain;

import static racingcar.domain.RacingCarRule.CAR_MOVE_CONDITION_MORE_THAN_NUMBER;

public class CarForwardStrategy implements CarForwardCondition {

    @Override
    public boolean isMoveable(int number) {
        if (number >= CAR_MOVE_CONDITION_MORE_THAN_NUMBER) {
            return true;
        }
        return false;
    }
}
