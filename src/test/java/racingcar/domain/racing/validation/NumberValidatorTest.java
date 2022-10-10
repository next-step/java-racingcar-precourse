package racingcar.domain.racing.validation;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.Test;

class NumberValidatorTest {

    RacingValidator validator = new NumberValidator();

    @Test
    void 횟수가_숫자면_통과() {
        assertThatNoException().isThrownBy(() -> validator.validate("12"));
    }

    @Test
    void 횟수가_숫자가_아니면_EX_발생() {
        assertThatIllegalArgumentException().isThrownBy(() -> validator.validate("십일"))
                .withMessageStartingWith("[ERROR]");
    }

}