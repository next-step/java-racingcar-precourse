package racingcar.common;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PositionTest {

    @Test
    void 전진하면_위치가_한칸_증가한다() {
        Position position = new Position();
        Integer forwardCount = 3;

        for (int index = 0; index < forwardCount; index ++) {
            position.forward();
        }

        assertThat(position.getPosition()).isEqualTo(forwardCount);
    }

    @Test
    void 입력된_숫자만큼_전진하면_해당_숫자만큼_증가한다() {
        Position position = new Position();
        Integer moveDistance = 10;
        position.forward(moveDistance);
        assertThat(position.getPosition()).isEqualTo(moveDistance);
    }
}