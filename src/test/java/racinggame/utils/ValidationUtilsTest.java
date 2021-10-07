package racinggame.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ValidationUtilsTest {

    @Test
    @DisplayName("숫자인가?")
    void isNumberic(){
        assertThat(ValidationUtils.isNumberic("가나다")).isFalse();
        assertThat(ValidationUtils.isNumberic("123")).isTrue();
    }

    @Test
    @DisplayName("자동차 이름은 5자 이하인가")
    void validateCarName(){
        assertThat(ValidationUtils.validateCarName("큰자동차12")).isFalse();
        assertThat(ValidationUtils.validateCarName("자동차12")).isTrue();
    }
}
