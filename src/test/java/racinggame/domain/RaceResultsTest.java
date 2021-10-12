package racinggame.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class RaceResultsTest {

    @Test
    public void 다수의_RaceResult를_가진다() {
        RacingCar r1 = new RacingCar(new CarName("1"));
        RacingCar r2 = new RacingCar(new CarName("2"));
        RaceResults raceResult = new RaceResults(Arrays.asList(r1, r2));

        Assertions.assertThat(raceResult.getRaceResults().isEmpty()).isFalse();
    }

    @Test
    public void 선두_레이서의_거리를_구한다() {
        RacingCar r1 = new RacingCar(new CarName("1"));
        RacingCar r2 = new RacingCar(new CarName("2"));
        r2.move(4);

        RaceResults raceResult = new RaceResults(Arrays.asList(r1, r2));

        Assertions.assertThat(raceResult.calculateLeadDistance()).isEqualTo(1);
    }

    @Test
    public void 우상자를_판별한다() {
        RacingCar r1 = new RacingCar(new CarName("1"));
        RacingCar r2 = new RacingCar(new CarName("2"));
        r2.move(4);

        RaceResults raceResult = new RaceResults(Arrays.asList(r1, r2));
        Winners winners = raceResult.judgeWinners();

        Assertions.assertThat(winners.getWinnersName()).isEqualTo(r2.getName());
    }
}
