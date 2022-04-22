package racingcar.model.record;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.lap.LapCount;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingRecordTest {
    @Test
    @DisplayName("경주 기록을 생성한다.")
    void makeRacingRecord() {
        // given
        List<CarRecord> carRecordList = new ArrayList<>();
        carRecordList.add(new CarRecord("car1", new LinkedList<>(), true));
        carRecordList.add(new CarRecord("car2", new LinkedList<>(), true));
        carRecordList.add(new CarRecord("car3", new LinkedList<>(), false));
        CarRecords carRecords = new CarRecords(carRecordList);
        LapCount lapCount = new LapCount("5");

        // when
        RacingRecord racingRecord = new RacingRecord(carRecords, lapCount);

        // then
        assertThat(racingRecord.getLapCount()).isEqualTo(5);
        assertThat(racingRecord.getChampionNames()).hasSize(2);
    }
}
