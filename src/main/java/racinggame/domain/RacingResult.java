package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingResult {
    public List<Car> result;

    public RacingResult() {
        this.result = new ArrayList<>();
    }

    public void addResult(Car car) {
        result.add(car);
    }
}
