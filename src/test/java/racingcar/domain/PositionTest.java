package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.Position;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @Test
    void Position_생성() {
        Position position = new Position(0);

        assertThat(position).isEqualTo(new Position(0));
    }

    @Test
    void 예외테스트_Position_음수_생성() {
        assertThatThrownBy(() -> new Position(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이동하기() {
        Position position = new Position(0);

        assertThat(position.next()).isEqualTo(new Position(1));
    }
}