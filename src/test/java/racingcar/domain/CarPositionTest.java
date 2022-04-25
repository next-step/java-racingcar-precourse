package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarPositionTest {

    @Test
    void 자동차_위치를_잘꺼내오는지_테스트() {

        // given when
        CarPosition cartPosition = new CarPosition(1);

        // then
        assertThat(cartPosition.getPosition()).isEqualTo(1);
    }

    @Test
    void 하나만큼_움직인_POSTION은_같은_객체이다() {

        // given when
        CarPosition cartPosition = new CarPosition(1);

        // then
        assertThat(new CarPosition(1)).isEqualTo(cartPosition);
    }
}
