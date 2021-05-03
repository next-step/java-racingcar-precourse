package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidationUtilsTest {
    @Test
    @DisplayName("자동차_이름_길이_5이하_true")
    void car_length_true_test(){
        boolean result = ValidationUtils.validName("hello");
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("자동차_이름_길이_5초과_false")
    void car_length_false_test(){
        boolean result = ValidationUtils.validName("helloCar");
        assertThat(result).isFalse();
    }

}
