package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RaceValidatorTest {

    private RaceValidator raceValidator = new RaceValidator();

    @Test
    @DisplayName("자동차 이름 분리 Test")
    void 자동차_이름_분리_TEST(){
        //given
        String testInput1 = "a,b,c";
        String testInput2 = "a,a,c";
        String testInput3 = "abcdef,b,c";

        //when
        String[] getTest1 = raceValidator.checkSplitCarsName(testInput1);

        //then
        assertThat(getTest1.length).isEqualTo(3);
        assertThat(getTest1[0]).isEqualTo("a");

        assertThatThrownBy(() -> raceValidator.checkSplitCarsName(testInput2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 중복될 수 없습니다.");


        assertThatThrownBy(() -> raceValidator.checkSplitCarsName(testInput3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1 ~ 5자 입니다.");
    }

    @Test
    @DisplayName("시도 횟수 유효 Test")
    void 시도_횟수_유효_TEST(){
        //given
        String testNum1 = "100";
        String testNum2 = "2147483648";
        String testNum3 = "-1";

        //when
        int getTestNum1 = raceValidator.checkValidTryNumber(testNum1);

        //then
        assertThat(getTestNum1).isEqualTo(Integer.parseInt(testNum1));

        assertThatThrownBy(() -> raceValidator.checkValidTryNumber(testNum2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1 이상 2,147,483,647 이하의 자연수만 입력 가능합니다.");

        assertThatThrownBy(() -> raceValidator.checkValidTryNumber(testNum3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1 이상 자연수만 입력 가능합니다.");
    }

}