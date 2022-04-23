package racingcar.racing;

import racingcar.car.Car;

import java.util.HashMap;
import java.util.List;

public class LapResults {
    private final HashMap<String, String> lapResults;

    public LapResults(List<Car> cars) {
        HashMap<String, String> result = new HashMap<>();
        for (Car car : cars) {
            result.put(car.getName().toText(), car.getPosition().toResultText());
        }
        this.lapResults = result;
    }

    public HashMap<String, String> getLapResult() {
        return this.lapResults;
    }
}
