package racingcar.model.record;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Records {
    private static final String NEXT_LINE = "\n";
    private static final String RANKER_DELIMITER = ",";
    private static final int FIRST_RECORD_IDX = 0;
    private final List<Record> records = new ArrayList<>();

    public void addRecord(Record record) {
        this.records.add(record);
    }

    public String recordsSheet() {
        StringBuilder sheet = new StringBuilder();
        for (Record record : records) {
            sheet
                    .append(record.report())
                    .append(NEXT_LINE);
        }

        return sheet.toString();
    }

    public String rankSheet() {
        StringBuilder sheet = new StringBuilder();
        Queue<Record> rankers = rankers();
        while (!rankers.isEmpty()) {
            appendRankerToSheet(sheet, rankers.poll(), rankers.isEmpty());
        }

        return sheet.toString();
    }

    private Queue<Record> rankers() {
        Queue<Record> rankerQueue = new LinkedList<>();
        for (Record record : records) {
            pushIfFirstRecord(record, rankerQueue);
            rank(record, rankerQueue);
        }

        return rankerQueue;
    }

    private void pushIfFirstRecord(Record record, Queue<Record> rankerQueue) {
        if (rankerQueue.isEmpty()) {
            rankerQueue.offer(record);
        }
    }

    private void rank(Record currentRecord, Queue<Record> rankerQueue) {
        if (rankerQueue.peek() != currentRecord) {
            higherProcess(currentRecord, rankerQueue);
            sameProcess(currentRecord, rankerQueue);
        }
    }

    private void higherProcess(Record currentRecord, Queue<Record> rankerQueue) {
        Record lastRecord = rankerQueue.peek();
        if (currentRecord.isHigherThan(lastRecord)) {
            rankerQueue.poll();
            rankerQueue.offer(currentRecord);
        }
    }

    private void sameProcess(Record currentRecord, Queue<Record> rankerQueue) {
        Record lastRecord = rankerQueue.peek();
        if (currentRecord.isSameWith(lastRecord)) {
            rankerQueue.offer(currentRecord);
        }
    }

    private void appendRankerToSheet(StringBuilder sheet, Record ranker, boolean lastRanker) {
        sheet.append(ranker.carName());
        if (!lastRanker) {
            sheet.append(RANKER_DELIMITER);
        }
    }
}
