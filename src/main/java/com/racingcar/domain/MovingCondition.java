package com.racingcar.domain;

import com.racingcar.exception.RacingCarGameException;
import com.racingcar.exception.RacingCarGameExceptionMessage;

import java.util.Objects;

public class MovingCondition {

    public static final Integer MIN_CONDITION_VALUE = 0;
    public static final Integer MAX_CONDITION_VALUE = 9;

    private final Integer condition;

    private MovingCondition(Integer condition) {
        validateConditionNumber(condition);
        this.condition = condition;
    }

    private void validateConditionNumber(Integer target) {
        if (!isValidConditionNumber(target)) {
            throw new RacingCarGameException(RacingCarGameExceptionMessage.INVALID_RANDOM_VALUE);
        }
    }

    private Boolean isValidConditionNumber(Integer target) {
        return target >= MIN_CONDITION_VALUE && target <= MAX_CONDITION_VALUE;
    }

    public Boolean biggerThan(MovingCondition that) {
        return condition >= that.condition;
    }

    public Boolean smallerThan(MovingCondition that) {
        return condition <= that.condition;
    }

    public static MovingCondition of(Integer condition) {
        return new MovingCondition(condition);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovingCondition that = (MovingCondition) o;
        return Objects.equals(condition, that.condition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(condition);
    }
}
