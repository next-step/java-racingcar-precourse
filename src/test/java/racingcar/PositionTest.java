package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.model.Position;

class PositionTest {

    @Test
    public void 위치_객체_생성시_최초_위치는_0이다() {
        // given
        Position position = new Position();

        // when
        int value = position.getPosition();

        // then
        Assertions.assertThat(value).isEqualTo(0);
    }

    @Test
    public void 위치값_이동시_기존_위치보다_1이_증가한다() {
        // given
        Position position = new Position();
        int beforeValue = position.getPosition();

        // when
        position.move();
        int afterValue = position.getPosition();

        // then
        Assertions.assertThat(beforeValue + 1).isEqualTo(afterValue);
    }
}