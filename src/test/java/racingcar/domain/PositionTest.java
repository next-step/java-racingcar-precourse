package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class PositionTest {

    @Test
    void Position_객체_끼리_비교() {
        Position position = new Position(1);
        assertThat(position).isEqualTo(new Position(1));
    }

    @Test
    void 위치값을_증가_시킬수_있다() {
        Position position = new Position(1);
        assertThat(position.movePosition()).isEqualTo(new Position(2));
    }

    @Test
    void Position에_음수값_검증() {
        assertThatThrownBy(
                () -> new Position(-1)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
