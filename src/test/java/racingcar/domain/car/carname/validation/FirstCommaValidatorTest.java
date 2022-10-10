package racingcar.domain.car.carname.validation;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.Test;

class FirstCommaValidatorTest {

    CarNamesValidator validator = new FirstCommaValidator();

    @Test
    void 쉼표로_시작하지_않으면_통과() {
        assertThatNoException().isThrownBy(() -> validator.validate("pobi,woni"));
    }

    @Test
    void 쉼표로_시작하면_EX_발생() {
        assertThatIllegalArgumentException().isThrownBy(() -> validator.validate(",pobi,woni"))
                .withMessageStartingWith("[ERROR]");
    }

}