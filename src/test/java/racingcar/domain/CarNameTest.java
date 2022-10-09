package racingcar.domain;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class CarNameTest {

    @Test
    @DisplayName("자리수 검증1")
    void carNameLength1(){
        CarName carName = new CarName("pobi");
    }

    @Test
    @DisplayName("자리수 검증2")
    void carNameLength2(){
        CarName carName = new CarName("java1");
    }

    @Test
    @DisplayName("자리수 검증3")
    void carNameLength3(){
        CarName carName = new CarName();
        assertThatIllegalArgumentException().isThrownBy(()-> carName.carNameCheck("java12"));
    }

    @Test
    @DisplayName("빈값 검증")
    void carNameEmpty(){
        CarName carName = new CarName();
        assertThatIllegalArgumentException().isThrownBy(()-> carName.isCheck(""));
    }

}