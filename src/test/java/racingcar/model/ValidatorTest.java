package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {
    private Validator validator = new Validator();

    @Test
    @DisplayName("자동차 이름 파싱 Test")
    void 자동차_이름_파싱_TEST(){
        //given
        String testInput1 = "a,b,c,";
        String testInput2 = "aaaaaa,b,c";
        String testInput3 = "a,a,c";
        String testInput4 = "a, ,c";

        // when & then
        assertThatThrownBy(() -> validator.checkCarsName(testInput1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 문자열의 마지막 문자가 ','일 수 없습니다.");

        assertThatThrownBy(() -> validator.checkCarsName(testInput2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1 ~ 5글자로 입력해주세요.");

        assertThatThrownBy(() -> validator.checkCarsName(testInput3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 중복될 수 없습니다.");

        assertThatThrownBy(() -> validator.checkCarsName(testInput4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1 ~ 5글자로 입력해주세요.");
    }

    @Test
    @DisplayName("시도 횟수 유효 Test")
    void 시도_횟수_유효_TEST(){
        //given
        String testNum1 = "2147483699";
        String testNum2 = "-1";

        //when & then
        assertThatThrownBy(() -> validator.checkTrialNumber(testNum1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1 이상 2,147,483,647 이하의 자연수만 입력 가능합니다.");

        assertThatThrownBy(() -> validator.checkTrialNumber(testNum2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1 이상 2,147,483,647 이하의 자연수만 입력 가능합니다.");
    }

}
