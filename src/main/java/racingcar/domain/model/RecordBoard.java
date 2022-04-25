package racingcar.domain.model;

import java.util.List;
import java.util.Optional;

public interface RecordBoard<T, S> {
    void updateRecord(String name, int distance);

    void resetRecord();

    List<T> findWinners();

    Optional<S> findRecord(String name);
}
