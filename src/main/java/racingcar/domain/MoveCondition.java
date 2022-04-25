package racingcar.domain;

@FunctionalInterface
public interface MoveCondition {
    boolean isSatisfied();
}
