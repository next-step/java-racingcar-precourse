package racingcar.view;

import java.util.List;

public interface OutputView <T, S> {
    void printRaceProgress(List<T> list);
    void printWinners(List<S> list);
}
