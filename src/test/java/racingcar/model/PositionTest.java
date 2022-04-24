package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositionTest {
    @DisplayName("포지션을 생성할 때, 포지션 값 등록이 성공한다.")
    @Test
    void setPositionSuccess_P01() {
        Position position = new Position(1);
        assertThat(position.getPosition()).isEqualTo(1);
    }

    @DisplayName("포지션에 값을 추가할 때, 포지션 값 등록이 성공한다.")
    @Test
    void setPositionSuccess_P02() {
        Position position = new Position(1);
        position.setPosition(2);
        assertThat(position.getPosition()).isEqualTo(3);
    }
}
