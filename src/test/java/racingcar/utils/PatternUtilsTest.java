package racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("utils ( PatternUtils )")
class PatternUtilsTest {

    @DisplayName("특수문자를 포함하는 경우")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"~", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")"})
    public void contain_special_character_test(String specialChracter) {
        // When && Then
        assertThat(PatternUtils.containSpecialCharacter(specialChracter)).isTrue();
    }

    @Test
    @DisplayName("특수문자를 포함하지 않는 경우")
    public void not_contain_special_character_test() {
        // Given
        String numberStr;

        // When
        numberStr = "123";

        // Then
        assertThat(PatternUtils.containSpecialCharacter(numberStr)).isFalse();
    }

    @DisplayName("숫자외의 문자를 포함하는 경우")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"~", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")"})
    public void not_contain_only_digit_test(String specialChracter) {
        // When && Then
        assertThat(PatternUtils.containOnlyDigit(specialChracter)).isFalse();
    }

    @Test
    @DisplayName("오직 숫자만 포함하는 경우")
    public void contain_only_digit_test() {
        // Given
        String numberStr;

        // When
        numberStr = "123";

        // Then
        assertThat(PatternUtils.containOnlyDigit(numberStr)).isTrue();
    }
}