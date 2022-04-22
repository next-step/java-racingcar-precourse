package racingcar.model.racing;

import racingcar.dto.CarRecordDto;
import racingcar.dto.RacingRecordDto;
import racingcar.model.car.CarEntries;
import racingcar.model.lap.LapCount;
import racingcar.model.movement.MovementStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Racing {
    private final CarEntries carEntries;
    private final LapCount lapCount;

    Racing(CarEntries carEntries, LapCount lapCount) {
        this.carEntries = carEntries;
        this.lapCount = lapCount;
    }

    public static RacingBuilder builder() {
        return new RacingBuilder();
    }

    public RacingRecordDto start(MovementStrategy movementStrategy) {
        for (int i = 0; i < lapCount.getCount(); i++) {
            carEntries.race(movementStrategy);
        }

        return makeRecord();
    }

    private RacingRecordDto makeRecord() {
        List<CarRecordDto> carRecords = carEntries.convertCarRecords();
        List<String> winnerNames = getWinnerNames(carRecords);

        return new RacingRecordDto(carRecords, winnerNames, lapCount.getCount());
    }

    private List<String> getWinnerNames(List<CarRecordDto> carRecords) {
        List<String> winnerNames = new ArrayList<>();
        for (CarRecordDto carRecord : carRecords) {
            addWinnerName(winnerNames, carRecord);
        }
        return Collections.unmodifiableList(winnerNames);
    }

    private void addWinnerName(List<String> winnerNames, CarRecordDto carRecord) {
        if (carRecord.isWinner()) {
            winnerNames.add(carRecord.getName());
        }
    }
}
