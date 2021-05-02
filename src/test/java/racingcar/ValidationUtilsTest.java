package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidationUtilsTest {

    @ParameterizedTest
    @DisplayName("자동차 이름 체크 - 적절한 이름")
    @ValueSource(strings = {"pobi", "racer"})
    void validateName_valid(String name) {
        assertThat(ValidationUtils.isValidName(name)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("자동차 이름 체크 - 부적절한 이름")
    @ValueSource(strings = {"Lightning", "Invalid"})
    void validateName_invalid(String name) {
        assertThat(ValidationUtils.isValidName(name)).isFalse();
    }
}
