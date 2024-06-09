package validate;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidatorTest {
    Validator validator = new Validator();
    char symbol = ',';
    int carNameNum = 5;
    @Test
    void 경주_인원() {
        //given
        String raceInput = "a";
        //when
        Throwable exception = assertThrows(IllegalStateException.class, () ->{
            validator.validateRaceInput(raceInput, symbol, carNameNum);
        });
        //then
        assertThat("[ERROR] 경주는 두 명 이상일 때 할 수 있습니다.").isEqualTo(exception.getMessage());
    }

    @Test
    void 이름_중복_검사(){
        //given
        String raceInput = "a,a,b";
        //when
        Throwable exception = assertThrows(IllegalArgumentException.class, () ->{
            validator.validateRaceInput(raceInput, symbol, carNameNum);
        });
        //then
        assertThat("[ERROR] 중복된 자동차의 이름이 있습니다.").isEqualTo(exception.getMessage());
    }

    @Test
    void 이름_글자수_검사(){
        //given
        String raceInput = "aaaaa,bbbbbb";
        //when
        Throwable exception = assertThrows(IllegalArgumentException.class, () ->{
            validator.validateRaceInput(raceInput, symbol, carNameNum);
        });
        //then
        assertThat("[ERROR] 자동차 이름은 5글자 이하만 가능합니다. 이름 초과 : " + "bbbbbb").isEqualTo(exception.getMessage());
    }

    @Test
    void 시도_횟수_숫자() {
        //given
        String raceNum = "a";
        //when
        Throwable exception = assertThrows(IllegalArgumentException.class, () ->{
            validator.validateRaceCount(raceNum);
        });
        //then
        assertThat("[ERROR] 숫자만 입력할 수 있습니다.").isEqualTo(exception.getMessage());
    }

    @Test
    void 시도_횟수_2미만() {
        //given
        String raceNum = "1";
        //when
        Throwable exception = assertThrows(IllegalArgumentException.class, () ->{
            validator.validateRaceCount(raceNum);
        });
        //then
        assertThat("[ERROR] 2이상의 숫자만 입력할 수 있습니다.").isEqualTo(exception.getMessage());
    }
}