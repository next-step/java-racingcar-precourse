package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {

    @DisplayName("racingCar을 하나 생성하면 처음에는 position이 0이다.")
    @Test
    void createRacingCar() {
        // given
        RacingCar pobi = RacingCar.of("pobi");

        // then
        assertThat(pobi.getPosition()).isEqualTo(0);
    }

    @DisplayName("racingCar의 포지션 만큼 '-' 를 생성해서 반환한다.")
    @Test
    void racingCarPosition() {
        // given
        RacingCar pobi = RacingCar.testInstance("pobi", 3);

        // when
        String repeat = pobi.racingCarPosition();

        // then
        assertThat(repeat).contains("---");
    }

}
