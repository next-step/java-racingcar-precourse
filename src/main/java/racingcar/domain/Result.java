package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Result {

    private final List<Records> recordsList;

    private Result(List<Records> recordsList) {
        this.recordsList = recordsList;
    }

    public static Result createInitialResult() {
        return new Result(new ArrayList<>());
    }

    public List<Records> getRecordsList() {
        return recordsList;
    }

    public void add(Records records) {
        recordsList.add(records);
    }

    public Winners getWinner() {
        int lastRoundNumber = recordsList.size() - 1;
        Records records = recordsList.get(lastRoundNumber);
        Winners winners = records.getWinners();
        return winners;
    }

}
