package racingcar.view;

public interface InputView<T, N> {
    T readNames();

    N readTryCount();
}
