package racingcar.domain.car.carname.validation;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DuplicateCarNameValidatorTest {

    CarNameValidator validator = new DuplicateCarNameValidator();

    @Test
    @DisplayName("중복 된 이름일 경우 EX 발생")
    void validate() {
        assertThatNoException().isThrownBy(() -> validator.validate("pobi"));
        assertThatIllegalArgumentException().isThrownBy(() -> validator.validate("pobi"));
    }

}