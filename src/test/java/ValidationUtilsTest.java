import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.ValidationUtils;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidationUtilsTest {

    @Test
    @DisplayName("자동차이름_5자_이하_검증")
    void 자동차이름_5자_이하_검증() {
        assertThat(ValidationUtils.validName("name")).isTrue();
        assertThat(ValidationUtils.validName("nameT")).isTrue();
        assertThat(ValidationUtils.validName("nameTest")).isFalse();
    }

    @Test
    @DisplayName("시도횟수_숫자이외의_값_검증")
    void 시도횟수_숫자이외의_값_검증() {
        assertThat(ValidationUtils.validTryNo("5")).isTrue();
        assertThat(ValidationUtils.validTryNo("test")).isFalse();
        assertThat(ValidationUtils.validTryNo("!")).isFalse();
        assertThat(ValidationUtils.validTryNo("")).isFalse();
    }

    @Test
    @DisplayName("랜덤값_1_9_검증")
    void 랜덤값_1_9_검증() {
        assertThat(ValidationUtils.validRandomValue(0)).isTrue();
        assertThat(ValidationUtils.validRandomValue(9)).isTrue();
        assertThat(ValidationUtils.validRandomValue(1)).isTrue();
        assertThat(ValidationUtils.validRandomValue(10)).isFalse();
    }
}