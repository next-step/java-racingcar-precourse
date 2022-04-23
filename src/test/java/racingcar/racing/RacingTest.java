package racingcar.racing;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.car.CarName;

import java.util.Arrays;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest extends NsTest {
    Racing racing;
    Lap lap;
    LapResults lapResults;
    Entry entry = new Entry(CarName.splitInputCarNames("ray,k3,niro"));
    private static final String LAP_COUNT = "3";

    @BeforeEach
    void setup() {
        racing = new Racing(entry);
        lap = new Lap(LAP_COUNT);
    }

    @Test
    void 레이싱_경기_진행_검증() {
        assertRandomNumberInRangeTest(
                () -> {
                    progressLap(racing, lap);
                    assertThat(entry.getEntryList().get(0).getPosition().toNumber()).isEqualTo(3);
                    assertThat(entry.getEntryList().get(1).getPosition().toNumber()).isEqualTo(1);
                    assertThat(entry.getEntryList().get(2).getPosition().toNumber()).isEqualTo(2);
                },
                4, 3, 3, 5, 2, 9, 6, 4, 9
        );
    }

    @Test
    void 레이싱_경기_LAP별_텍스트_확인() {
        assertRandomNumberInRangeTest(
                () -> {
                    lapResults = racing.lapResult();
                    assertThat(lapResults.getLapResult().get("ray")).isEqualTo("-");
                    assertThat(lapResults.getLapResult().get("k3")).isEqualTo("");
                    lapResults = racing.lapResult();
                    assertThat(lapResults.getLapResult().get("ray")).isEqualTo("--");
                    assertThat(lapResults.getLapResult().get("k3")).isEqualTo("-");
                },
                4, 3, 3, 5, 9, 3
        );
    }

    @Test
    void 레이싱_경기_우승자_두명_검증() {
        assertRandomNumberInRangeTest(
                () -> {
                    progressLap(racing, lap);
                    assertThat(racing.winners().getWinners()).containsAll(Arrays.asList("ray", "k3"));
                },
                4, 4, 3, 5, 5, 3, 6, 6, 3
        );
    }

    void progressLap(Racing racing, Lap lap) {
        for (int i = 0; i < lap.getCount(); i++) {
            racing.lapResult();
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
