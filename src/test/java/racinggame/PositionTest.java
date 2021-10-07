package racinggame;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @Test
    void positionMove() {

        Position position = Position.of();
        position.move(4);
        assertThat(position.matchPosition(1)).isTrue();

    }

    @Test
    void positionNotMove() {

        Position position = Position.of();
        position.move(3);
        assertThat(position.matchPosition(0)).isTrue();

    }
}