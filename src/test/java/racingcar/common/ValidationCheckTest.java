package racingcar.common;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ValidationCheckTest {

    public ValidationCheck validationCheck = new ValidationCheck();

    @Test
    void 자동차_이름_길이_정합성_검사() {
        assertThat(validationCheck.carNamelengthValidation("car")).isEqualTo(true);
        assertThat(validationCheck.carNamelengthValidation("racingCar")).isEqualTo(false);
    }

    @Test
    void 시도_횟수_숫자_정합성_검사() {
        assertThat(validationCheck.numberValidation("123")).isEqualTo(true);
        assertThat(validationCheck.numberValidation("abc")).isEqualTo(false);
    }
}
