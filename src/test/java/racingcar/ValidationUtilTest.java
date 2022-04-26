package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.utils.ValidationUtils;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidationUtilTest {

    @ParameterizedTest
    @DisplayName("이름 유효성 검증")
    @CsvSource(value = {"1, true", "홍길동, true", "여섯자리이상, false", ", false"})
    void test01(String input, boolean expected) {
        assertThat(ValidationUtils.validateCarName(input, ValidationUtils.CAR_NAME_LENGTH_LIMIT)).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("자동차 이동 횟수 입력 검증")
    @CsvSource(value = {"1, true", "홍길동, false", "13233, true", ", false"})
    void test02(String input, boolean expected) {
        assertThat(ValidationUtils.isNumeric(input)).isEqualTo(expected);
    }

    @Test
    @DisplayName("','구분자 여러개 입력 시 검증")
    void test03() {
        assertThat(ValidationUtils.validateSeparator("123,,")).isFalse();
    }
}
