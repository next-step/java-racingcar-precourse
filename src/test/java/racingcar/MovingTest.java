package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MovingTest {

    @Test
    void 앞으로_전진() {
        assertThat(Moving.isMove(8)).isTrue();
        assertThat(Moving.isMove(3)).isFalse();
    }

}
