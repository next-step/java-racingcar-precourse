package racingcar.domain;

import javafx.util.Pair;
import racingcar.constant.ErrorMessage;

import java.util.List;

public class Record {
    private List<Pair<String, Integer>> recordsByRound;

    public Record(List<Pair<String, Integer>> recordsByRound) {
        validate(recordsByRound);
        this.recordsByRound = recordsByRound;
    }

    public List<Pair<String, Integer>> getRecordsByRound() {
        return recordsByRound;
    }

    private void validate(List<Pair<String, Integer>> recordsByRound) {
        if (recordsByRound.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_RECORD);
        }
    }
}
