package racingcar.dto;

import java.util.List;

public class RacingRecordDto {
    private final List<CarRecordDto> carRecords;
    private final List<String> winnerNames;
    private final int lapCount;

    public RacingRecordDto(List<CarRecordDto> carRecords, List<String> winnerNames, int lapCount) {
        this.carRecords = carRecords;
        this.winnerNames = winnerNames;
        this.lapCount = lapCount;
    }

    public List<CarRecordDto> getCarRecords() {
        return carRecords;
    }

    public List<String> getWinnerNames() {
        return winnerNames;
    }

    public int getLapCount() {
        return lapCount;
    }
}
