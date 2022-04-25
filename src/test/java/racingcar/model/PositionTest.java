package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {
    @Test
    @DisplayName("Position 이 3번 증가하면 toString()은 문자열 - 를 3개 리턴한다")
    void toStringOverride() {
        Position position = new Position();
        position.increase();
        position.increase();
        position.increase();
        assertThat(position.toString()).isEqualTo("---");
    }

    @Test
    @DisplayName("입력 값이 3, Position 이 3이면 true를 반환한다")
    void maxPositionSame() {
        Position position = new Position(3);
        assertThat(position.isMaxPosition(3)).isTrue();
    }

    @Test
    @DisplayName("입력 값이 2, Position 이 3이면 true를 반환한다")
    void maxPositionMoreThan() {
        Position position = new Position(3);
        assertThat(position.isMaxPosition(2)).isTrue();
    }

    @Test
    @DisplayName("입력 값이 3, Position 이 4이면 false를 반환한다")
    void maxPositionLowerThen() {
        Position position = new Position(3);
        assertThat(position.isMaxPosition(4)).isFalse();
    }
}
