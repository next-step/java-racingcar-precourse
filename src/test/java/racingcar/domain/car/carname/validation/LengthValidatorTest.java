package racingcar.domain.car.carname.validation;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.Test;

class LengthValidatorTest {

    CarNameValidator validator = new LengthValidator();

    @Test
    void 이름이_5자리_이하면_통과() {
        assertThatNoException().isThrownBy(() -> validator.validate("pobi"));
    }

    @Test
    void 이름이_5자리_넘으면_EX_발생() {
        assertThatIllegalArgumentException().isThrownBy(() -> validator.validate("yoonmin"))
                .withMessageStartingWith("[ERROR]");
    }

}