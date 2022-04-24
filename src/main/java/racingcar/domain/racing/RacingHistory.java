package racingcar.domain.racing;

import java.util.List;
import racingcar.domain.racing.car.Cars;

public class RacingHistory {
    private final List<Cars> history;

    private RacingHistory(List<Cars> history) {
        this.history = history;
    }

    public static RacingHistory from(List<Cars> history) {
        return new RacingHistory(history);
    }

    public List<Cars> get() {
        return history;
    }
}
