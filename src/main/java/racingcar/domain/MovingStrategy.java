package racingcar.domain;

@FunctionalInterface
public interface MovingStrategy {

    boolean decide(int number);
}
