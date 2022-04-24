package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    void 지정된_횟수만큼_레이스_진행() {
        int number = 3;
        Cars cars = new Cars(Arrays.asList("yoshi", "kirby"));
        NumberOfAttempts attempts = new NumberOfAttempts(number);
        Game game = new Game(cars, attempts);

        while (number > 0) {
            game.race();
            number--;
        }
        assertThat(game.isContinue()).isFalse();
    }
}
