package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidationUtilsTest {
    @Test
    @DisplayName("전진_숫자_1_9_검증")
    void validateNumber() {
        assertThat(ValidationUtils.validateNumber(9)).isTrue();
        assertThat(ValidationUtils.validateNumber(0)).isTrue();
        assertThat(ValidationUtils.validateNumber(-1)).isFalse();
        assertThat(ValidationUtils.validateNumber(10)).isFalse();
    }
}
