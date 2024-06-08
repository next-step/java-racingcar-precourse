package controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.ErrorConstants;

public class InputValidatorTest {
    @Test
    @DisplayName("입력 문자열이 쉼표로 구분된 올바른 형식일 때 유효성 검사 통과")
    void validCommaSeparatedStrings() {
        String input = "name1, name2, name3";
        List<String> result = InputValidator.validateCommaSeparatedStrings(input);
        assertThat(result).containsExactly("name1", "name2", "name3");
    }

    @Test
    @DisplayName("입력 문자열에 공백이 있을 때 앞뒤 공백이 제거되고 유효성 검사 통과")
    void validCommaSeparatedStringsWithSpaces() {
        String input = " name1 , name2 , name3 ";
        List<String> result = InputValidator.validateCommaSeparatedStrings(input);
        assertThat(result).containsExactly("name1", "name2", "name3");
    }

    @Test
    @DisplayName("입력 문자열이 쉼표로 구분되지 않은 경우 예외 발생")
    void invalidCommaSeparatedStrings() {
        String input = "name1; name2; name3";
        assertThatThrownBy(() -> InputValidator.validateCommaSeparatedStrings(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorConstants.INADEQUATE_INPUT);
    }

    @Test
    @DisplayName("입력 문자열이 비어 있을 때 예외 발생")
    void blankInputString() {
        String input = "";
        assertThatThrownBy(() -> InputValidator.validateCommaSeparatedStrings(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorConstants.BLANK);
    }

    @Test
    @DisplayName("입력 문자열이 숫자가 아닌 경우 예외 발생")
    void nonIntegerString() {
        String input = "name1, name2, notanumber";
        assertThatThrownBy(() -> InputValidator.isInteger(input.split(",")[2].trim()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorConstants.OVER_INTEGER);
    }

}
