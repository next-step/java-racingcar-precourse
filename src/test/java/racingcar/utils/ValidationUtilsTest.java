package racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.utils.ValidationUtils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationUtilsTest {

    @Test
    @DisplayName("자동차_입력값_이름_검증")
    void car_input_validation(){
        assertThat(new ValidationUtils().validName("pobi")).isTrue();
        assertThat(new ValidationUtils().validName("pobi,java")).isTrue();
        assertThat(new ValidationUtils().validName("pobi,javaji")).isFalse();
        assertThat(new ValidationUtils().validName("pobi,java,pobi")).isFalse();
        assertThat(new ValidationUtils().validName("")).isFalse();
        assertThat(new ValidationUtils().validName(",")).isFalse();
        assertThat(new ValidationUtils().validName(",,,")).isFalse();
    }

    @Test
    @DisplayName("게임_경주_횟수_검증")
    void repeatCount_validation(){
        assertThat(new ValidationUtils().validRepeat("1")).isTrue();
        assertThat(new ValidationUtils().validRepeat("9")).isTrue();
        assertThat(new ValidationUtils().validRepeat("10")).isTrue();
        assertThat(new ValidationUtils().validRepeat("0")).isFalse();
        assertThat(new ValidationUtils().validRepeat("-1")).isFalse();
        assertThat(new ValidationUtils().validRepeat("-")).isFalse();
        assertThat(new ValidationUtils().validRepeat("abc")).isFalse();
    }

}
