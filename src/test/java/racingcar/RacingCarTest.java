package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @Test
    @DisplayName("자동차의 이름 구분")
    void separate_car_name() {
        assertThat(RacingCar.separateName("pobi,crong,honux")).isEqualTo(Arrays.asList("pobi", "crong", "honux"));
    }

    @Test
    @DisplayName("이름이 5자 이하인지 검증")
    void name_5_less_than() {
        assertThat(RacingCar.checkLen("pobi")).isTrue();
        assertThat(RacingCar.checkLen("pobiaaa")).isFalse();
    }
}
