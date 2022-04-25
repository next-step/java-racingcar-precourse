package racingcar.validator.name;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NextStepValidatorNameTest {

    @Test
    @DisplayName("NextStepValidatorName가 정상길이의 자동차 이름에 대해 에러를 발생 시키는지 확인한다.")
    void 비정상_INPUT_검증() {
        assertThatThrownBy(
                () -> {
                    ValidatorName validatorName = new NextStepValidatorName();
                    validatorName.validateCarsName("carname");
                }
        ).isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("이름의 길이가 잘못되었습니다.");
    }

    @Test
    @DisplayName("NextStepValidatorName가 정상길이의 자동차 이름에 대해 에러를 발생 시키지 않는지 확인한다.")
    void 정상_INPUT_검증() {
        assertThatCode(
                () -> {
                    ValidatorName validatorName = new NextStepValidatorName();
                    validatorName.validateCarsName("card");
                }
        ).doesNotThrowAnyException();
    }
}