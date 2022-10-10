package racingcar.service;

@FunctionalInterface
public interface CallBackInputValue<T> {

    T execute();
}
