package racingcar.domain.racing.validation;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PositiveNumberValidatorTest {

    RacingValidator validator = new PositiveNumberValidator();

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    void 횟수가_양수면_통과(String tryNo) {
        assertThatNoException().isThrownBy(() -> validator.validate(tryNo));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-2"})
    void 횟수가_0이하면_EX_발생(String tryNo) {
        assertThatIllegalArgumentException().isThrownBy(() -> validator.validate(tryNo))
                .withMessageStartingWith("[ERROR]");
    }

}