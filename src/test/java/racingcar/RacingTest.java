package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.models.*;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;


public class RacingTest {

    @Test
    public void 배열에서_NULL_제거() {
        Car[] sampleArray = {new Car("sampl"), null};

        assertThat(sampleArray)
                .containsNull()
                .satisfies(array -> {
                    RacingVO vo = new RacingVO(array, new GameCount("5"));
                    assertThat(new Racing(vo).removeNullFromArray(array))
                            .doesNotContainNull();
                });
    }

    @Test
    public void 단독_우승자() {
        Car car1 = new Car("race1");
        Car car2 = new Car("race2");
        Car car3 = new Car("race3");
        Car[] sampleArray = {car1, car2, car3};

        RacingVO vo = new RacingVO(sampleArray, new GameCount("5"));
        RacingScore sampleScores = new RacingScore();
        sampleScores.addScore(car1, 3);
        sampleScores.addScore(car2, 4);
        sampleScores.addScore(car3, 5);
        Car[] winners = new Racing(vo).getWinners(sampleScores);
        assertThat(winners)
                .hasSize(1)
                .isEqualTo(new Car[]{car3});
    }

    @Test
    public void 공동_우승자() {
        Car car1 = new Car("race1");
        Car car2 = new Car("race2");
        Car car3 = new Car("race3");
        Car[] sampleArray = {car1, car2, car3};

        RacingVO vo = new RacingVO(sampleArray, new GameCount("5"));
        RacingScore sampleScores = new RacingScore();
        sampleScores.addScore(car1, 1);
        sampleScores.addScore(car2, 5);
        sampleScores.addScore(car3, 5);
        Car[] winners = new Racing(vo).getWinners(sampleScores);
        assertThat(winners)
                .hasSize(2)
                .isEqualTo(new Car[]{car2, car3});
    }
}
