package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.domain.Position;

public class PositionTest {

    @Test
    public void create_position_test() {
        Position position = new Position(1);
        assertThat(position).isEqualTo(new Position(1));
    }

    @Test
    public void move_test() {
        Position position = new Position();
        assertThat(position.move()).isEqualTo(new Position(1));
    }

    @Test
    public void get_position_test() {
        Position position = new Position(5);
        assertThat(position.getValue()).isEqualTo(5);
    }
}
