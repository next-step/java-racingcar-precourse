package racinggame;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @Test
    void positionMove() {

        Position position = Position.of();
        position.move(true);
        assertThat(position.matchPosition(1)).isTrue();

    }

    @Test
    void positionNotMove() {

        Position position = Position.of();
        position.move(false);
        assertThat(position.matchPosition(0)).isTrue();

    }

    @Test
    void positionCompare() {

        Position pobi = Position.of();
        Position crong = Position.of();

        pobi.move(true);

        assertThat(pobi.comparePosition(crong)).isTrue();
    }
}