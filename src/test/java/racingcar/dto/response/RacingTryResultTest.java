package racingcar.dto.response;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.racing.car.Car;
import racingcar.domain.racing.car.Cars;

public class RacingTryResultTest {
    private Cars cars;
    private String expected;

    @BeforeEach
    void setUp() {
        cars = Cars.from(Arrays.asList(
                Car.of("pobi", 3),
                Car.of("woni", 1),
                Car.of("jun", 2)
        ));

        expected = "pobi : ---\n" + "woni : -\n" + "jun : --\n";
    }

    @Test
    @DisplayName("ToString의 결과는 차수별 실행 결과이다")
    void ToString의_결과는_차수별_실행_결과이다() {
        assertThat(RacingTryResult.from(cars).toString()).isEqualTo(expected);
    }
}
