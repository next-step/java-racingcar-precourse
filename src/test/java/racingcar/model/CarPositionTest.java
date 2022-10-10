package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarPositionTest {

    @Test
    @DisplayName("0보다 크거나 같고 4미만은 숫자는 포지션이 바뀌지 않는다")
    void modifyPosition_fail() {
        CarPosition position = new CarPosition();
        assertAll(
                () -> assertThat(position.modifyPosition(GameNumber.of("0"))).isEqualTo(0),
                () -> assertThat(position.modifyPosition(GameNumber.of("3"))).isEqualTo(0));

    }

    @Test
    @DisplayName("4이상의 숫자는 포지션이 1 바뀐다")
    void modifyPosition_success() {
        CarPosition position = new CarPosition();
        assertAll(
                () -> assertThat(position.modifyPosition(GameNumber.of("4"))).isEqualTo(1),
                () -> assertThat(position.modifyPosition(GameNumber.of("9"))).isEqualTo(2)
        );

    }
}