package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class ProgressTest {
    @Test
    void 진행횟수가_0일때_에러() {
        assertThatThrownBy(() -> {
            Progress progress = new Progress(0);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}