package com.racingcar.domain;

import com.racingcar.exception.RacingCarGameException;

import java.util.Objects;

public class MovingCondition {

    private final Integer condition;

    private MovingCondition(Integer condition) {
        validateConditionNumber(condition);
        this.condition = condition;
    }

    private void validateConditionNumber(Integer target) {
        if (!isValidConditionNumber(target)) {
            throw new RacingCarGameException("랜덤을 생성된 값이 유효하지 않습니다.");
        }
    }

    private Boolean isValidConditionNumber(Integer target) {
        return target >= 0 && target <= 9;
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
