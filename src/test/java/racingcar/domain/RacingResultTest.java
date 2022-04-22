package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class RacingResultTest {
    @Test
    void 우승자를_출력한다() {
        Cars cars = new Cars(Arrays.asList("pobi", "woni"));
        cars.move(() -> true);
        RacingResult result = new RacingResult(cars);
        assertThat(result.createWinnerMessage()).isEqualTo("최종 우승자 : pobi, woni");
    }
}
