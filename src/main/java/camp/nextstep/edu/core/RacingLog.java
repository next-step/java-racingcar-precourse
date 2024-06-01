package camp.nextstep.edu.core;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RacingLog {
    private final Map<String, Integer> racingLog;

    private RacingLog(Map<String, Integer> racingLog) {
        this.racingLog = racingLog;
    }

    public static RacingLog of(List<Car> cars) {
        return new RacingLog(cars.stream().collect(Collectors.toMap(Car::getName, Car::getPosition)));
    }

    public Map<String, Integer> getRacingLogs() {
        return racingLog;
    }

    @Override
    public String toString() {
        return racingLog.entrySet().stream()
                .map(entry -> entry.getKey() + " : " + "-".repeat(entry.getValue()))
                .collect(Collectors.joining("\n"));
    }
}
