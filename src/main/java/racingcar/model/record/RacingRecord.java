package racingcar.model.record;

import racingcar.model.lap.LapCount;

import java.util.ArrayList;
import java.util.List;

public class RacingRecord {
    private final CarRecords carRecords;
    private final LapCount lapCount;

    public RacingRecord(CarRecords carRecords, LapCount lapCount) {
        this.carRecords = carRecords;
        this.lapCount = lapCount;
    }

    public int getLapCount() {
        return lapCount.getLapCount();
    }

    public List<String> getChampionNames() {
        List<String> champions = new ArrayList<>();
        for (int i = 0; i < carRecords.size(); i++) {
            addChampion(champions, carRecords.get(i));
        }
        return champions;
    }

    private void addChampion(List<String> champions, CarRecord carRecord) {
        if (carRecord.isChampion()) {
            champions.add(carRecord.getName());
        }
    }

    public int getCarRecordSize() {
        return carRecords.size();
    }

    public CarRecord getCarRecord(int index) {
        return carRecords.get(index);
    }
}
