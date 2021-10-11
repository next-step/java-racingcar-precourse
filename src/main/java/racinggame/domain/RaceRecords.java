package racinggame.domain;

import java.util.List;

public class RaceRecords {
    List<RaceRecord> raceRecords;

    public RaceRecords(List<RaceRecord> raceRecords) {
        this.raceRecords = raceRecords;
    }

    public void report() {
        if (this.raceRecords == null) {
            return;
        }

        for (RaceRecord raceRecord : raceRecords) {
            raceRecord.report();
        }
        System.out.println();
    }
}
