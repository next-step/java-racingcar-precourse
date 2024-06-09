package utils;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    @DisplayName("이름이 2개 미만 입력되었을 경우 에러 발생")
    void validateNames_NamesCountsLessThanTwo_ThrowsException() {
        List<String> names = List.of("name1");

        Assertions.assertThatThrownBy(() -> InputValidator.validateNames(names))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("0글자의 이름이 입력되었을 경우 에러 발생")
    void validateNames_EmptyName_ThrowsException() {
        List<String> names = List.of("name1", "name2", "");

        Assertions.assertThatThrownBy(() -> InputValidator.validateNames(names))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("6글자 이상의 이름이 입력되었을 경우 에러 발생")
    void validateNames_NameLengthMoreThan6_ThrowsException() {
        List<String> names = List.of("name1", "name2", "name345");

        Assertions.assertThatThrownBy(() -> InputValidator.validateNames(names))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복되는 이름이 입력되었을 경우 에러 발생")
    void validateNames_DuplicatedNames_ThrowsException() {
        List<String> names = List.of("name1", "name2", "name2");

        Assertions.assertThatThrownBy(() -> InputValidator.validateNames(names))
            .isInstanceOf(IllegalArgumentException.class);
    }
}