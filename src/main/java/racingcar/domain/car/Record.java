package racingcar.domain.car;

import java.util.HashMap;
import java.util.Map;

public class Record {

    private Map<Integer, Cars> record;

    public Record() {
        record = new HashMap<>();
    }

    public void add(int count, Cars cars) {
        this.record.put(count, cars);
    }

    public Cars getRecord(int key) {
        return record.get(key);
    }

    public Integer size() {
        return record.size();
    }
}
