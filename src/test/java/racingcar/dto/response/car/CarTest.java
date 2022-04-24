package racingcar.dto.response.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.response.car.Car;

public class CarTest {
    @Test
    @DisplayName("ToString의 결과는 자동차 이름과 위치를 표현하다")
    void ToString의_결과는_자동차_이름과_위치를_표현하다() {
        assertThat(Car.of("pobi", 5).toString()).isEqualTo("pobi : -----");
    }
}
