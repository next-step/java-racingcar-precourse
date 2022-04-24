package racingcar.domain;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Result {
    List<Record> recordList;

    public Result(List<Record> recordList) {
        this.recordList = recordList;
    }

    public List<Record> getRecordList() {
        return recordList;
    }

    public List<String> pickFinalWinners() {
        int maxDistance = pickMaxDistance();
        List<String> result = carsWithDistance(maxDistance);
        return result;
    }

    private List<String> carsWithDistance(int maxDistance) {
        Record finalRecord = recordList.get(recordList.size() - 1);
        List<String> result = new ArrayList<>();

        for (Pair<String, Integer> recordByRound: finalRecord.getRecordsByRound()) {
            addNameIfHasSameDistance(result, recordByRound, maxDistance);
        }
        return result;
    }

    private void addNameIfHasSameDistance(List<String> result, Pair<String, Integer> recordByRound, int maxDistance) {
        if (recordByRound.getValue() == maxDistance) {
            result.add(recordByRound.getKey());
        }
    }

    private int pickMaxDistance() {
        int ret = 0;
        Record finalRecord = recordList.get(recordList.size() - 1);
        for (Pair<String, Integer> recordsByRound : finalRecord.getRecordsByRound()) {
            ret = Math.max(recordsByRound.getValue(), ret);
        }
        return ret;
    }
}
