package racingcar.model.progress;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class MoveScoreTest {
    @Test
    void 변환() {
        int expected = 4;
        assertThat(MoveScore.of(expected).get()).isEqualTo(expected);
    }
}
