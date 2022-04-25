package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.utils.ValidationUtils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InputValueValidation {

    @Test
    void 자동차_이름_Validation() {
        assertThat(ValidationUtils.validCarName("nuts")).isTrue();
        assertThat(ValidationUtils.validCarName("PEAnuts")).isFalse();
        assertThat(ValidationUtils.validCarName(" ")).isFalse();
    }

    @Test
    void 자동차_이동횟수_Validation() {
        assertThat(new ValidationUtils("3").isValidRoundNum()).isTrue();
        assertThat(new ValidationUtils("삼").isValidRoundNum()).isFalse();
        assertThat(new ValidationUtils("4.4").isValidRoundNum()).isFalse();
        assertThat(new ValidationUtils("0").isValidRoundNum()).isFalse();
    }
}
