package racingcar.domain;

import racingcar.common.NaturalNumber;

import java.util.*;

public class RaceResult implements Iterable<DriveRecord> {
    private final List<DriveRecord> records;

    public RaceResult(List<DriveRecord> records) {
        this.records = records;
    }

    public NaturalNumber getRecordSize() {
        return new NaturalNumber(records.size());
    }

    public List<DriveRecord> getWinner() {
        NaturalNumber winnerPosition = getWinnerPosition();
        return filterWinnersBy(winnerPosition);
    }

    private NaturalNumber getWinnerPosition() {
        NaturalNumber maxPosition = NaturalNumber.of(0);
        for (int i = 0; i < this.records.size(); i++) {
            maxPosition = findMaxPosition(maxPosition, i);
        }
        return maxPosition;
    }

    private NaturalNumber findMaxPosition(NaturalNumber maxPosition, int i) {
        DriveRecord record = this.records.get(i);
        if (record.isGreaterThan(maxPosition)) {
            maxPosition = record.getCarPosition();
        }
        return maxPosition;
    }

    private List<DriveRecord> filterWinnersBy(NaturalNumber winnerPosition) {
        List<DriveRecord> winnerRecord = new ArrayList<>();
        for (DriveRecord record : records) {
            addWinners(winnerPosition, record, winnerRecord);
        }
        return winnerRecord;
    }

    private void addWinners(NaturalNumber winnerPosition, DriveRecord record, List<DriveRecord> winnerRecords) {
        if (record.isAt(winnerPosition)) {
            winnerRecords.add(record.copy());
        }
    }

    @Override
    public Iterator<DriveRecord> iterator() {
        return records.iterator();
    }
}
