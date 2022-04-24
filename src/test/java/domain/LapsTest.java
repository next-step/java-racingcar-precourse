package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LapsTest {

    @Test
    @DisplayName("이동횟수_입력값_검증")
    void 이동횟수_입력값_검증() {
        assertThat(Laps.validate("0")).isFalse();
        assertThat(Laps.validate("1")).isTrue();
        assertThat(Laps.validate("99")).isTrue();
        assertThat(Laps.validate("a")).isFalse();
    }
}
