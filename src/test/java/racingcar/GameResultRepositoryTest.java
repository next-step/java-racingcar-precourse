package racingcar;
import org.junit.jupiter.api.Test;
import racingcar.models.*;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultRepositoryTest {

    @Test
    public void mergeScores() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("mode9");

        GameResult gameResult1 = new GameResult(new Car[]{car1, car2});
        gameResult1.addResult(car1, false);
        gameResult1.addResult(car2, true);
        GameResult gameResult2 = new GameResult(new Car[]{car1, car2});
        gameResult2.addResult(car1, true);
        gameResult2.addResult(car2, true);
        int expectCar1Score = 1;
        int expectCar2Score = 2;

        GameResultRepository repo = new GameResultRepository(new GameResult[]{gameResult1, gameResult2});

        RacingScore scores = repo.getScores();
        assertThat(scores.size()).isEqualTo(2);
        assertThat(scores.getCars()).contains(car1, car2);
        assertThat(scores.getScoreOf(car1)).isEqualTo(expectCar1Score);
        assertThat(scores.getScoreOf(car2)).isEqualTo(expectCar2Score);

    }
}
