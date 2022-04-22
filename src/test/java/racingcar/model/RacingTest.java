package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingTest {

    public static final int COUNT = 5;

    @DisplayName("자동차 경주 종료 여부 확인")
    @Test
    void 자동차_경주_종료_여부_확인() {
        //given
        Racing car = new Racing("car", String.valueOf(COUNT));

        //when
        for (int i = 0; i < COUNT - 1; i++) {
            car.race();
            assertThat(car.isRunning()).isTrue();
        }

        car.race();
        assertThat(car.isRunning()).isFalse();
    }

}