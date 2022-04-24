package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarTest {

    @DisplayName("자동차 생성 후 이름 테스트")
    @Test
    void getNamePass_P01() {
        RacingCar car = new RacingCar("test");
        assertThat(car.getName()).isEqualTo("test");
    }
}
