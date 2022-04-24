package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {

    @Test
    @DisplayName("스트링 문자열이 숫자인지 판별")
    void isNumber() {
        assertThat(StringUtils.isNumber("1")).isTrue();
        assertThat(StringUtils.isNumber("a")).isFalse();
        assertThat(StringUtils.isNumber("-1")).isTrue();
        assertThat(StringUtils.isNumber("0")).isTrue();
    }
}
