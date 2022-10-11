package racingcar.car.value;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.common.exception.ErrorMessage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    @DisplayName("Position 객체는 음수를 가질 수 없다.")
    void cannotGetNegativeValue(){
        assertThatThrownBy(() -> {
            new Position(-10);
        }).hasMessageContaining(ErrorMessage.CAN_NOT_NEGATIVE.getMessage());
    }

    @Test
    @DisplayName("Position 초기값은 0이다.")
    void checkInitPosition(){
        Position position = new Position();
        assertThat(position.position()).isEqualTo(0);
    }

    @Test
    @DisplayName("move 메서드를 통해 position 을 1 증가시킨다.")
    void plusOnePositionByMove(){
        Position position = new Position();
        position.move();
        assertThat(position.position()).isEqualTo(1);
    }

}