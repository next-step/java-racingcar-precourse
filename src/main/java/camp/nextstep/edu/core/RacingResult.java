package camp.nextstep.edu.core;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public record RacingResult(List<RacingLog> racingLogs, List<Car> winners) {

    @Override
    public List<RacingLog> racingLogs() {
        return new ArrayList<>(racingLogs);
    }

    @Override
    public List<Car> winners() {
        return new ArrayList<>(winners);
    }

    @Override
    public String toString() {
        return racingLogs
                .stream()
                .map(RacingLog::toString)
                .reduce((log1, log2) -> log1 + "\n\n" + log2)
                .orElse("")
                + "\n\n최종 우승자: "
                + winners
                .stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }
}
