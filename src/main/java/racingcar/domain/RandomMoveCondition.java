package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveCondition implements MoveCondition {

    private final NumberRange numberRange;
    private final Threshold thresholdInclusive;


    public RandomMoveCondition(NumberRange numberRange, Threshold thresholdInclusive) {
        this.numberRange = numberRange;
        this.thresholdInclusive = thresholdInclusive;
    }

    public boolean doMove() {
        return thresholdInclusive.isAboveOrEqualTo(
                Randoms.pickNumberInRange(numberRange.getMinNumber(), numberRange.getMaxNumber()));
    }
}
