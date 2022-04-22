package racingcar.util;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {

    @DisplayName("빈 배열 검증 예외 처리")
    @Test
    void 빈_배열_검증_예외_처리() {
        String[] arr = {};

        assertThatIllegalArgumentException()
                .isThrownBy(() -> Validator.isEmptyArray(arr))
                .withMessageContaining(Validator.CAR_NAME_VALIDATE_EXCEPTION_MESSAGE);
    }

    @DisplayName("빈 배열 검증")
    @Test
    void 빈_배열_검증() {
        String[] arr = {"1", "2", "3"};

        Validator.isEmptyArray(arr);
    }

    @DisplayName("자동차 이름 검증 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "!", "이름", "abcdef"})
    void 자동차_이름_검증_예외_처리(String string) {
        //given
        //when
        //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Validator.checkRegex(string))
                .withMessageContaining(Validator.CAR_NAME_VALIDATE_EXCEPTION_MESSAGE);
    }

    @DisplayName("자동차 이름 검증")
    @ParameterizedTest
    @ValueSource(strings = {"a", "1", "1a", "a2c", "a1b2c",})
    void 자동차_이름_검증(String string) {
        //given
        //when
        //then
        Validator.checkRegex(string);
    }

    @DisplayName("시도 횟수 정수 검증 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "a", "!", "2147483648"})
    void 시도_횟수_정수_검증_예외_처리(String string) {
        //given
        //when
        //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Validator.isInteger(string))
                .withMessageContaining(Validator.INTEGER_EXCEPTION_MESSAGE);
    }

    @DisplayName("시도 횟수 정수 검증")
    @ParameterizedTest
    @ValueSource(strings = {"-2147483648", "-1", "0", "1", "2147483647"})
    void 시도_횟수_정수_검증(String string) {
        //given
        //when
        //then
        Validator.isInteger(string);
    }

    @DisplayName("시도 횟수 1 이상 검증 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "0"})
    void 시도_횟수_1_이상_검증_예외_처리(String string) {
        //given
        //when
        //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Validator.isGreaterThanZero(string))
                .withMessageContaining(Validator.GREATER_THAN_ZERO_EXCEPTION_MESSAGE);
    }

    @DisplayName("시도 횟수 1 이상 검증")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "2147483647"})
    void 시도_횟수_1_이상_검증_성공(String string) {
        //given
        //when
        //then
        Validator.isGreaterThanZero(string);
    }

}