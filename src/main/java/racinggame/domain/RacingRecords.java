package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingRecords {

    private final List<RacingRecord> racingRecords;


    public RacingRecords() {
        racingRecords = new ArrayList<>();
    }

    public void addResult(RacingRecord result) {
        racingRecords.add(result);
    }

    public int size() {
        return racingRecords.size();
    }

}
