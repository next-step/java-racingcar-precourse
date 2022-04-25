package racingcar.Util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ValidationTest {
    @Test
    @DisplayName("자동차 이름 길이 검증")
    public void validateNameLength() {
        assertThat(Validation.validateCarName("yang")).isTrue();
        assertThat(Validation.validateCarName("car")).isTrue();
        assertThat(Validation.validateCarName("dangdnag")).isFalse();
        assertThat(Validation.validateCarName("")).isFalse();
    }

    @Test
    @DisplayName("이동 횟수가 숫자인지 검증")
    public void validateMovementType() {
        assertThat(Validation.validateMovement("1")).isTrue();
        assertThat(Validation.validateMovement("79")).isTrue();
        assertThat(Validation.validateMovement("a")).isFalse();
        assertThat(Validation.validateMovement("0b")).isFalse();
    }
}
