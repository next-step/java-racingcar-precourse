package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PositionTest {
    private Position position;

    @BeforeEach
    void setUp() {
        position = new Position(0);
    }

    @Test
    void 자동차는_전진하는데_전진_조건은_0_9_값을_입력받는다() {
        new Position(0, () -> 0).move();
        new Position(0, () -> 9).move();
        assertThatIllegalArgumentException().isThrownBy(() -> new Position(0, () -> -1).move());
        assertThatIllegalArgumentException().isThrownBy(() -> new Position(0, () -> 10).move());
    }

    @Test
    void 자동차는_전진하는데_전진_조건은_4_이상일_경우_전진한다() {
        Position cannotMove = new Position(0, () -> 3);
        cannotMove.move();
        assertThat(cannotMove).isEqualTo(new Position(0));

        Position canMove = new Position(0, () -> 4);
        canMove.move();
        assertThat(canMove).isEqualTo(new Position(1));
    }

    @Test
    void 입력받은_값과_자신중에_큰_값을_반환한다() {
        assertThat(position.max(new Position(1))).isEqualTo(new Position(1));
        assertThat(position.max(new Position(0))).isEqualTo(new Position(0));
        assertThat(position.max(new Position(-1))).isEqualTo(new Position(0));
    }

}
