package racinggame.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RaceRecordTest {

    @Test
    public void 레코드를_기록한다() {
        RacingCar racingCar = new RacingCar(new CarName("정기"));
        RaceRecord raceRecord = new RaceRecord(racingCar);

        Assertions.assertThat(raceRecord.getCarName()).isEqualTo(racingCar.getName());
        Assertions.assertThat(raceRecord.getDistance()).isEqualTo(racingCar.getDistance());
    }
}
