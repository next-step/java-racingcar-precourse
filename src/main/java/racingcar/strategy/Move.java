package racingcar.strategy;

@FunctionalInterface
public interface Move {

    int move(final int currentDistance);
}
