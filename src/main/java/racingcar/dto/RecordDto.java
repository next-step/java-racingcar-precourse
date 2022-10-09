package racingcar.dto;

import java.util.List;

public class RecordDto {
    private final List<List<String>> lapPositions;
    private final List<String> winners;

    private RecordDto(List<List<String>> lapPositions, List<String> winners) {
        this.lapPositions = lapPositions;
        this.winners = winners;
    }

    public static RecordDto of(List<List<String>> lapPositions, List<String> winners) {
        return new RecordDto(lapPositions, winners);
    }

    public List<List<String>> getLapPositions() {
        return lapPositions;
    }

    public List<String> getWinners() {
        return winners;
    }
}
