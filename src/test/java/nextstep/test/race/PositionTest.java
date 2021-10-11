package nextstep.test.race;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.race.domain.Position;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {
    private Position position;
    @BeforeEach
    void setUp() {
        this.position = new Position();
    }

    @Test
    @DisplayName("포지션_증가_테스트")
    void 포지션_증가_테스트() {
        assertThat(position.getPosition()).isEqualTo(0);
        position.addPosition();
        assertThat(position.getPosition()).isEqualTo(1);
    }
}
