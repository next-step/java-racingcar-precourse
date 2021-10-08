package racinggame.domain;

import nextstep.utils.StringBuilderUtils;

import java.util.ArrayList;
import java.util.List;

import static racinggame.type.StringConstants.LINE_FEED;

public class RacingTimesRecord {

    private final List<RacingRecords> racingRecordsPerTimes;

    public RacingTimesRecord() {
        racingRecordsPerTimes = new ArrayList<>();
    }

    public void record(Cars cars) {
        RacingRecords racingRecords = new RacingRecords();
        for (int i = 0; i < cars.size(); i++) {
            racingRecords.addResult(RacingRecord.from(cars.get(i)));
        }
        racingRecordsPerTimes.add(racingRecords);
    }

    public int size() {
        return racingRecordsPerTimes.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size(); i++) {
            RacingRecords racingRecords = racingRecordsPerTimes.get(i);
            sb.append(racingRecords.toString())
                    .append(LINE_FEED)
                    .append(LINE_FEED);
        }
        return sb.toString();
    }
}
