package racingCar.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    @DisplayName("입력된 자동차 이름 유효성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {
            "",                                         // 자동차 개수가 0개인 예외
            "abcdef, car1, car2",                       // 이름이 5글자가 넘는 예외
            "car1,, ,,,car2",                           // 이름이 빈 문자열, 공백인 예외
            ", "                                        // 공백이 이름이 경우는 안 되므로 자동차가 0개인 예외
    })
    void validateInputCarName(String inputName) {
        Assertions.assertThatThrownBy(() ->
            InputValidator.validateInputCarName(inputName)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 시도 횟수 유효성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {
            "0",                        // 횟수는 1이상 100이하
            "101",
            "-1",
            "19242",
            "abc",                      // 입력은 숫자여야 한다
            "ab34"
    })
    void validateInputTryNum(String num) {
        Assertions.assertThatThrownBy(() ->
                        InputValidator.validateInputTryNum(num)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}