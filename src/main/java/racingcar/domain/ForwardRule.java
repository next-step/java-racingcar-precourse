package racingcar.domain;

@FunctionalInterface
public interface ForwardRule {
    boolean isForward(final int number);
}
