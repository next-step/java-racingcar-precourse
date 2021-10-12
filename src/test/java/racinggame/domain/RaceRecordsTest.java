package racinggame.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class RaceRecordsTest {

    @Test
    public void 다수의_Record를_가진다() {
        RaceRecord record1 = new RaceRecord(new RacingCar(new CarName("1")));
        RaceRecord record2 = new RaceRecord(new RacingCar(new CarName("1")));
        RaceRecords raceRecords = new RaceRecords(Arrays.asList(record1, record2));
        Assertions.assertThat(raceRecords.getRaceRecords().isEmpty()).isFalse();
    }
}
