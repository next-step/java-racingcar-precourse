package racingcar.dto.response.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.response.car.CarName;

public class CarNameTest {
    @Test
    @DisplayName("ToString의 결과는 자동차 이름이다")
    void ToString의_결과는_자동차_이름이다() {
        String carName = "car name";
        assertThat(CarName.from(carName).toString()).isEqualTo(carName);
    }
}
