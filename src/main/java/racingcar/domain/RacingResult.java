package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingResult {
    private final List<Car> winners;

    public RacingResult(List<Car> winners) {
        this.winners = winners;
    }

    public String getWinnerNames() {
        List<String> WinnerNames = new ArrayList<>();
        for (Car car : winners) {
            WinnerNames.add(car.getName());
        }
        return String.join(", ", WinnerNames);
    }
}
