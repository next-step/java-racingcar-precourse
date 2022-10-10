package racingcar.domain.car.carname.validation;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.Test;

class EmptyValidatorTest {

    CarNamesValidator validator = new EmptyValidator();

    @Test
    void 공백_아니면_통과() {
        assertThatNoException().isThrownBy(() -> validator.validate("pobi,woni,"));
    }

    @Test
    void 공백이면_EX_발생() {
        assertThatIllegalArgumentException().isThrownBy(() -> validator.validate(""))
                .withMessageStartingWith("[ERROR]");
    }
}