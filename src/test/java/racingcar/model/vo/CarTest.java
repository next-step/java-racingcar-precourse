package racingcar.model.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("자동차 이름 글자수 확인")
    void 자동차_이름_글자수_확인() {
        //5글자 이하
        String testName = "abcde";
        assertThat(Car.validateNameLength(testName)).isTrue();
        //5글자 초과
        testName = "abcdef";
        assertThat(Car.validateNameLength(testName)).isFalse();
    }

    @Test
    @DisplayName("자동차 이름 공백문자 외 문자 포함여부 확인")
    void 자동차_이름_유효성_확인() {
        //문자열이 null인 경우
        String testName = null;
        assertThat(Car.validateNameNotEmpty(testName)).isFalse();
        //공백만으로 이루어진 경우
        testName = "    ";
        assertThat(Car.validateNameNotEmpty(testName)).isFalse();
        //공백 외 다른 문자 포함된 경우
        testName = "ab  d";
        assertThat(Car.validateNameNotEmpty(testName)).isTrue();
    }

    @Test
    @DisplayName("자동차 이름 5글자 초과 시 예외처리")
    void 자동차_이름_글자수_초과_예외처리() {
        assertThatThrownBy(() -> {
            new Car("abcdef");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("자동차 이름 공백문자로만 이루어진 경우 예외처리")
    void 자동차_이름_빈값_예외처리() {
        assertThatThrownBy(() -> {
            new Car("   ");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
