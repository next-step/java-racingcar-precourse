package racingcar.domain.move;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.move.Position;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositionTest {

    @Test
    void 위치값이_하나_증가한다() {
        Position position = new Position(0);

        position.go();

        assertThat(position.get()).isEqualTo(1);
    }

    @Test
    @DisplayName("Equals_메시지를_호출했을때_위치가_동일하면_동일하다")
    void equalsTest() {
        Position me = new Position(2);
        Position other = new Position(2);

        assertEquals(me, other);
    }

    @Test
    void 위치값이_특정메시지로_표시된다() {
        Position empty = new Position(0);
        Position two = new Position(2);

        assertThat(empty.toString()).isEqualTo("");
        assertThat(two.toString()).isEqualTo("--");
    }
}
