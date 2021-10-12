package racinggame.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RaceResultTest {

    @Test
    public void 레이싱카의_결과를_가진다() {
        RacingCar racingCar = new RacingCar(new CarName("정기"));
        RaceResult raceResult = new RaceResult(racingCar);

        Assertions.assertThat(raceResult.getName()).isEqualTo(racingCar.getName());
        Assertions.assertThat(raceResult.getDistance()).isEqualTo(racingCar.getDistance());
    }

    @Test
    public void 선두를_판별한다() {
        RacingCar racingCar = new RacingCar(new CarName("정기"));
        racingCar.move(4);

        RaceResult raceResult = new RaceResult(racingCar);
        Assertions.assertThat(raceResult.isLeadRacer(1)).isTrue();
    }
}
