package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositionTest {

    @DisplayName("자동차 위치를 생성할 수 있다.")
    @Test
    void create() {
        assertAll(
            () -> assertDoesNotThrow(() -> new Position()),
            () -> assertDoesNotThrow(() -> new Position(1))
        );
    }

    @DisplayName("자동차 위치는 0보다 작을 수 없다.")
    @Test
    void negativePosition() {
        assertThatThrownBy(
            () -> new Position(-1)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 위치 간 동등성을 비교할 수 있다.")
    @Test
    void equals() {
        final Position position1 = new Position();
        final Position position2 = new Position();
        final Position position3 = new Position(1);
        final Position position4 = new Position(1);

        assertAll(
            () -> assertThat(position1).isEqualTo(position2),
            () -> assertThat(position3).isEqualTo(position4)
        );
    }
}
