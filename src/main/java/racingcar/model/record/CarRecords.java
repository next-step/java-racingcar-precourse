package racingcar.model.record;

import java.util.ArrayList;
import java.util.List;

public class CarRecords {
    private final List<CarRecord> records;

    public CarRecords(List<CarRecord> records) {
        this.records = new ArrayList<>(records);
    }

    public int size() {
        return records.size();
    }

    public CarRecord get(int index) {
        return records.get(index);
    }
}
