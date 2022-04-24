package racingcar.models;

import java.util.ArrayList;
import java.util.List;
import jdk.jfr.Description;

public class RaceRecords {

    private final List<RaceRecord> records;

    public RaceRecords() { this.records = new ArrayList<>(); }



    public void add(RaceRecord record) {
        this.records.add(record);
    }

    public int count() {
        return this.records.size();
    }

    public int getStepsByCarName(String carName) {
        List<RaceRecord> records = this.findAllByCarNameAndRaceResult(carName, RaceResult.GO);
        return records.size();
    }


    private List<RaceRecord> findAllByCarNameAndRaceResult(String carName, RaceResult raceResult) {
        List<RaceRecord> records = new ArrayList<>();
        for (RaceRecord record: this.records) {
            this.setRecordsIfEqualCarNameAndRaceResult(records, record, carName, raceResult);
        }
        return records;
    }

    private void setRecordsIfEqualCarNameAndRaceResult(List<RaceRecord> records, RaceRecord baseRecord, String carName, RaceResult result) {
        if (baseRecord.isEqualCarByName(carName) && baseRecord.isEqualResult(result)) {
            records.add(baseRecord);
        }
    }

}
