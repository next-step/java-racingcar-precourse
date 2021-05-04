package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidationUtilsTest {
    @Test
    @DisplayName("자동차_이름_길이_5이하_true")
    void car_length_true_test() {
        boolean result = ValidationUtils.validName("hello");
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("자동차_이름_길이_5초과_false")
    void car_length_false_test() {
        boolean result = ValidationUtils.validName("helloCar");
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("자동차_이름_중복_확인_true")
    void car_name_duplication_true() {
        boolean result = ValidationUtils.duplicateName(Arrays.asList("hello", "pobi", "pobi2", "hello"));
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("자동차_이름_중복_확인_false")
    void car_name_duplication_false() {
        boolean result = ValidationUtils.duplicateName(Arrays.asList("hello", "pobi", "pobi2", "hi"));
        assertThat(result).isFalse();
    }

}
