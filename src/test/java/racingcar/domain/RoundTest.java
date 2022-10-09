package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class RoundTest {

    @Test
    @DisplayName("숫자 검증1 --> 숫자 여러자리")
    void roundNumberCheck1(){
        Round round = new Round(12332);
    }

    @Test
    @DisplayName("숫자 검증2 --> 숫자 이외의 값일 경우 EXCEPTION")
    void roundNumberCheck2(){
        Round round = new Round();
        assertThatIllegalArgumentException().isThrownBy(()-> round.inputRegex("de"));
    }

    @Test
    @DisplayName("빈값 검증")
    void roundEmpty(){
        Round round = new Round();
        assertThatIllegalArgumentException().isThrownBy(()-> round.isCheck(""));
    }

}