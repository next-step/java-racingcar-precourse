package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class PositionTest {

    @Test
    @DisplayName("앞으로 전진")
    void moveForward() {
        Position position = new Position();
        position.moveForward();
        assertThat(1).isSameAs(position.getPosition());
        position.moveForward();
        assertThat(2).isSameAs(position.getPosition());
    }

    @Test
    @DisplayName("위치 출력")
    void positionToString() {
        Position position = new Position(2);
        assertThat(position.toString()).isEqualTo("--");
    }

}
