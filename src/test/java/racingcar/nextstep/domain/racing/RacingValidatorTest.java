package racingcar.nextstep.domain.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.nextstep.domain.racing.service.RacingValidator;
import racingcar.nextstep.global.message.ErrorMessage;
import racingcar.nextstep.infrastructure.racing.RacingValidatorImpl;

import static org.assertj.core.api.Assertions.*;

class RacingValidatorTest {

    RacingValidator racingValidator = new RacingValidatorImpl();

    @Test
    @DisplayName("시도 횟수 입력 - 숫자가 아닌 문자를 입력했으면 IllegalArgumentException 발생")
    void isNumber_fail() {
        //given
        final String inputNumber = "12a";
        //when && then
        assertThatThrownBy(() -> racingValidator.isNumber(inputNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.IS_NOT_NUMBER);
    }

    @Test
    @DisplayName("자동차 이름이 5글자 이상인게 있으면 IllegalArgumentException 발생")
    void isCarNameNotExceedingFive() {
        //given
        final String[] carNameList = {"pobiaaa", "crongbbbbbbbbb", "honux"};
        //when && then
        assertThatThrownBy(() -> racingValidator.isCarNameNotExceedingFive(carNameList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NAME_EXCEED);
    }

    @Test
    @DisplayName("자동차 이름이 공백이면 IllegalArgumentException 발생")
    void isCarNameNotBlank() {
        //given
        final String[] carNameList = {"   ", "", " "};
        //when && then
        assertThatThrownBy(() -> racingValidator.isCarNameNotBlank(carNameList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NAME_NOT_BLANK);
    }

}