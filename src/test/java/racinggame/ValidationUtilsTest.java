package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.domain.utils.ValidationUtils;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidationUtilsTest {

    @ParameterizedTest
    @CsvSource(value = {"차", "자동차", "슈퍼자동차"})
    @DisplayName("자동차 이름 5자리 이하 유효성 테스트")
    void validate_car_name_length(String input) {
        assertTrue(ValidationUtils.validCarName(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong,honuxxxxx"})
    @DisplayName("사용자로 부터 받은 자동차 이름들이 콤마로 구분되어 있는지 테스트")
    void validate_user_input_could_split_with_comma_false(String input){
        assertFalse(ValidationUtils.validSplitableCarNames(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,    crong,   honux"})
    @DisplayName("사용자로 부터 받은 자동차 이름들이 콤마로 구분되어 있는지 테스트")
    void validate_user_input_could_split_with_comma_true(String input){
        assertTrue(ValidationUtils.validSplitableCarNames(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    @DisplayName("1~9 자리 숫자인지 확인")
    void validNumbersBetweenOne2Nine(int input) {
        assertTrue(ValidationUtils.validNumbersBetweenOneAndNine(input));
    }

    @Test
    @DisplayName("시도할 회수 입력 받은 것이 숫자로 변환되는지 확인")
    void validGameRound() {
        assertTrue(ValidationUtils.validGameRound("3"));
        assertFalse(ValidationUtils.validGameRound("삼"));
    }
}
