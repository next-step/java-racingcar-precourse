package racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidUtilTest {
    @DisplayName("빈 문자 입력시 에러 발생")
    @ParameterizedTest
    @ValueSource(strings = { "", " " })
    void empty(String string) {
        assertThatThrownBy(() -> ValidUtil.emptyString(string)).isInstanceOf(IllegalArgumentException.class);
    }
}