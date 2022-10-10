package racingcar.model.race;

import java.util.ArrayList;
import java.util.List;

/**
 * 경기 기록 객체
 *
 * @author YONGSEOK CHOI
 * @version 1.0 2022.10.09
 */
public class Record {

    private final List<Result> record = new ArrayList<>();

    public Result getFinalResult() {
        return record.get(record.size() - 1);
    }

    public void addRecord(Result result) {
        record.add(result);
    }

    public int getRecordSize() {
        return record.size();
    }
}
