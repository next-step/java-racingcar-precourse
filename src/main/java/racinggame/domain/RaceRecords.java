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
        StringBuilder message = new StringBuilder();
        for (RaceRecord raceRecord : raceRecords) {
            message.append(raceRecord.reportMessage());
        }
        System.out.println(message);
    }

    public List<RaceRecord> getRaceRecords() {
        return raceRecords;
    }
}
