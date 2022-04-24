package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    @DisplayName("포지션이 하나 증가 된다")
    void add() {
        Position position = new Position(0);
        position.add();
        assertThat(position.getPosition()).isEqualTo(1);
        position.add();
        assertThat(position.getPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("포지션 갯수만큼 -로 치환된다")
    void getString() {
        assertThat(new Position(3).toString()).isEqualTo("---");
    }

    @Test
    @DisplayName("포지션의 값은 음수가 될 수 없다.")
    void minusPosition() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Position(-1));
    }
}