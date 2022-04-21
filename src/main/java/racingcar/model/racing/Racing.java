package racingcar.model.racing;

import racingcar.model.car.Entries;
import racingcar.model.record.CarRecords;
import racingcar.model.record.RacingRecord;

public class Racing {
    private final Entries entries;
    private final LapCount lapCount;

    Racing(Entries entries, LapCount lapCount) {
        this.entries = entries;
        this.lapCount = lapCount;
    }

    public static RacingBuilder builder() {
        return new RacingBuilder();
    }

    public RacingRecord start(RacingStrategy racingStrategy) {
        for (int i = 0; i < lapCount.getLapCount(); i++) {
            entries.race(racingStrategy);
        }

        return makeRacingRecord();
    }

    private RacingRecord makeRacingRecord() {
        CarRecords carRecords = entries.convertCarRecords();

        return new RacingRecord(carRecords, lapCount);
    }
}
