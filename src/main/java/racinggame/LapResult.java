package racinggame;

import java.util.ArrayList;
import java.util.List;

public class LapResult {
    private final List<Record> records = new ArrayList<>();

    public void add(Record record) {
        records.add(record);
    }

    public List<Record> getBestRecords() {
        Record highestRecord = findHighestRecord();
        return findAllByRecord(highestRecord);
    }

    private List<Record> findAllByRecord(Record highestRecord) {
        List<Record> result = new ArrayList<>();
        for (Record record : records) {
            addBestRecord(highestRecord, result, record);
        }
        return result;
    }

    private void addBestRecord(Record highestRecord, List<Record> result, Record record) {
        if (highestRecord.matchPosition(record)) {
            result.add(record);
        }
    }

    private Record findHighestRecord() {
        Record best = null;
        for (Record record : records) {
            best = assignHighestRecord(best, record);
        }
        return best;
    }

    private Record assignHighestRecord(Record bestRecord, Record record) {
        if (bestRecord == null || record.compareTo(bestRecord) > 0) {
            bestRecord = record;
        }
        return bestRecord;
    }
}
