package camp.nextstep.edu.core;

import java.util.List;
import java.util.stream.Collectors;

public class RacingResult {
    private final List<RacingLog> racingLogs;
    private final List<Car> winners;

    public RacingResult(List<RacingLog> racingLogs, List<Car> winners) {
        this.racingLogs = racingLogs;
        this.winners = winners;
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
