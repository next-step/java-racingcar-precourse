package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidationUtilsTest {

    @ParameterizedTest
    @ValueSource(strings = {"123456789", "112", "1111", "-12"})
    @DisplayName("숫자만 있는 문자열로 숫자인지 검증하면 true 리턴한다.")
    void validate_numeric_text(String givenText) {
        boolean result = ValidationUtils.isNumeric(givenText);
        assertThat(result).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(strings = {"aaa", "a12", "12a", "", " ", "**123", "123$"})
    @DisplayName("숫자가 아닌 문자열로 숫자인지 검증하면 false 리턴한다.")
    void validate_invalid_numeric_text(String givenText) {
        boolean result = ValidationUtils.isNumeric(givenText);
        assertThat(result).isEqualTo(false);
    }

    @ParameterizedTest
    @ValueSource(strings = {"aaa", "bbb", "ccc", "이보현", "이보현aa"})
    @DisplayName("문자만 있는 문자열로 문자인지 검증하면 true 리턴한다.")
    void validate_alpha_text(String givenText) {
        boolean result = ValidationUtils.isAlpha(givenText);
        assertThat(result).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "^^"})
    @DisplayName("문자가 아닌 문자열로 문자인지 검증하면 false 리턴한다.")
    void validate_inavlid_alpha_text(String givenText) {
        boolean result = ValidationUtils.isAlpha(givenText);
        assertThat(result).isEqualTo(false);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "aa", "aaa"})
    @DisplayName("주어진 문자열 길이가 제한 길이 안에 속하면 true 리턴한다.")
    void validate_length(String givenText) {
        int minLength = 1;
        int maxLength = 3;
        boolean result = ValidationUtils.checkLength(minLength, maxLength, givenText);
        assertThat(result).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(strings = {"aaaa", "aaaaa", ""})
    @DisplayName("주어진 문자열 길이가 제한 길이 밖에 속하면 false 리턴한다.")
    void validate_invalid_length_text(String givenText) {
        int minLength = 1;
        int maxLength = 3;
        boolean result = ValidationUtils.checkLength(minLength, maxLength, givenText);
        assertThat(result).isEqualTo(false);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("주어진 문자열이 empty이면 true를 리턴한다.")
    void validate_empty(String givenText) {
        boolean result = ValidationUtils.isEmpty(givenText);
        assertThat(result).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2147483648", "-2147483649"})
    @DisplayName("시도 횟수가 int 범위를 벗어날 경우 false를 리턴한다.")
    void validate_invalid_range(String givenText) {
        boolean result = ValidationUtils.isInRange(givenText);
        assertThat(result).isEqualTo(false);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2147483647", "-2147483648", "0", "1"})
    @DisplayName("시도 횟수가 int 범위를 벗어나지 않을 경우 true를 리턴한다.")
    void validate_range(String givenText) {
        boolean result = ValidationUtils.isInRange(givenText);
        assertThat(result).isEqualTo(true);
    }
}
