package racingcar.model.racing;

import racingcar.model.car.CarEntries;
import racingcar.model.lap.LapCount;
import racingcar.model.movement.MovementStrategy;
import racingcar.model.record.CarRecords;
import racingcar.model.record.RacingRecord;

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

    public RacingRecord start(MovementStrategy movementStrategy) {
        for (int i = 0; i < lapCount.getLapCount(); i++) {
            carEntries.race(movementStrategy);
        }

        return makeRacingRecord();
    }

    private RacingRecord makeRacingRecord() {
        CarRecords carRecords = carEntries.convertCarRecords();

        return new RacingRecord(carRecords, lapCount);
    }
}
