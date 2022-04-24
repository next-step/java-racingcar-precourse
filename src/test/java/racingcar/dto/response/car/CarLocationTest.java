package racingcar.dto.response.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.response.car.CarLocation;

public class CarLocationTest {
    @Test
    @DisplayName("ToString의 결과는 자동차의 위치를 심볼로 표현한 값이다")
    void ToString의_결과는_자동차의_위치를_심볼로_표현한_값이다() {
        assertThat(CarLocation.from(3).toString()).isEqualTo("---");
    }
}
