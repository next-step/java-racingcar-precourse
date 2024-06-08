package controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.ErrorConstants;

public class InputValidatorTest {
    @Test
    @DisplayName("자동차 이름 입력을 받을 때 쉼표로 구분되지 않은 입력 시 IllegalArgumentException 발생")
    void isCommaSeparated_shouldThrowException_whenInputIsNotCommaSeparated() {
        // given
        String input = "car1;car2;car3" ;

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> InputValidator.validateCarName(input))
                .withMessage(ErrorConstants.INADEQUATE_INPUT);
    }

    @Test
    @DisplayName("자동차 이름 입력을 받을 때 5글자를 초과하는 이름이 있을 경우 IllegalArgumentException 발생")
    void isOver5Words_shouldThrowException_whenInputHasWordOver5Chars() {
        // given
        String input = "car1,carcar2" ; // "carcar2"는 5글자를 초과

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> InputValidator.validateCarName(input))
                .withMessage(ErrorConstants.OVER_FIVE_WORDS);
    }

    @Test
    @DisplayName("자동차 이름 입력을 받을 때 중복된 이름이 있을 경우 IllegalArgumentException 발생")
    void isDuplicate_shouldThrowException_whenInputHasDuplicateNames() {
        // given
        String input = "car1,car2,car1" ;

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> InputValidator.validateCarName(input))
                .withMessage(ErrorConstants.DUPLICATE_NAME);
    }

    @Test
    @DisplayName("유효한 자동차 이름 입력 시 성공적으로 리스트 반환")
    void validateCarName_shouldReturnList_whenInputIsValid() {
        // given
        String input = "car1,car2,car3" ;

        // when
        List<String> result = InputValidator.validateCarName(input);

        // then
        assertThat(result).containsExactly("car1", "car2", "car3");
    }

    @Test
    @DisplayName("레이스 카운트 입력 시 빈 문자열 입력 시 IllegalArgumentException 발생")
    void inputIsBlank_shouldThrowException_whenInputIsBlank() {
        // given
        String input = "" ;

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> InputValidator.validateRaceCount(input))
                .withMessage(ErrorConstants.OVER_INTEGER);
    }

    @Test
    @DisplayName("레이스 카운트 입력 시 숫자 형식이 아닌 입력 시 IllegalArgumentException 발생")
    void isInteger_shouldThrowException_whenInputIsNotInteger() {
        // given
        String input = "abc" ;

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> InputValidator.validateRaceCount(input))
                .withMessage(ErrorConstants.OVER_INTEGER);
    }

    @Test
    @DisplayName("레이스 카운트 입력 시 숫자가 범위를 벗어날 경우 IllegalArgumentException 발생")
    void isNumberInRange_shouldThrowException_whenNumberOutOfRange() {
        // given
        String input = "0" ;

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> InputValidator.validateRaceCount(input))
                .withMessage(ErrorConstants.OVER_RANGE);
    }

    @Test
    @DisplayName("유효한 레이스 카운트 입력 시 성공적으로 정수 반환")
    void validateRaceCount_shouldReturnInteger_whenInputIsValid() {
        // given
        String input = "5" ; // 유효한 범위 내 숫자

        // when
        int result = InputValidator.validateRaceCount(input);

        // then
        assertThat(result).isEqualTo(5);
    }


}
