package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class RacingResultTest {
    @Test
    void 우승자_문자열_생성() {
        List<Car> carList = Arrays.asList(
                new Car("aaa"),
                new Car("bbb")
        );
        RacingResult racingResult = new RacingResult(carList);

        assertThat(racingResult.getWinnerNames()).isEqualTo("aaa, bbb");
    }
}