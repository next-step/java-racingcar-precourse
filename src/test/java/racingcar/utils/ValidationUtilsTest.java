package racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static racingcar.utils.ValidationUtils.nameValidation;
import static racingcar.utils.ValidationUtils.roundValidation;

class ValidationUtilsTest {

    @ParameterizedTest
    @ValueSource(strings = {"asdsdf",""})
    @DisplayName("잘못된 이름 입력 테스트")
    void nameValidationExceptionTest(final String namesInput) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> nameValidation(namesInput));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "", "한글"})
    @DisplayName("잘못된 횟수 입력 테스트")
    void roundValidationExceptionTest(final String roundInput) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> roundValidation(roundInput));
    }
}