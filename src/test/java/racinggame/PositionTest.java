package racinggame;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    @Test
    public void move_test() {
        Position position = new Position(0);
        assertThat(position.move()).isEqualTo(new Position(1));
    }

    @Test
    public void get_position_test() {
        Position position = new Position(5);
        assertThat(position.getValue()).isEqualTo(5);
    }
}
