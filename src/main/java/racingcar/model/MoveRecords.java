package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class MoveRecords {
    private final List<MoveRecord> records = new ArrayList<>();

    public void addRecord(MoveRecord moveRecord) {
        records.add(moveRecord);
    }

    public List<MoveRecord> getRecords() {
        return records;
    }
}
