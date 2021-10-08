package racinggame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarPositionTest {
    private CarPosition position;

    @BeforeEach
    void setUp() {
        position = new CarPosition();
    }

    @Test
    void 생성확인() {
        assertThat(position.getPosition()).isEqualTo(0);
    }

    @Test
    void 이동확인() {
        position.move();
        assertThat(position.getPosition()).isEqualTo(1);
    }
}