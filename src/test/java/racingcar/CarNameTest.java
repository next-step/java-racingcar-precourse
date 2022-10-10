package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import racingcar.domain.CarName;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.Constants.ErrorMessage.ERR_MSG_TITLE;

class CarNameTest {

    @Test
    @DisplayName("자동차이름 다섯자 이상시 예외처리 테스트")
    public void carNameLengthTest(){
        //given
        String name = "sonata";

        //when then

        assertThatThrownBy(
                () -> {
                    new CarName(name);
                }
        )
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(ERR_MSG_TITLE);
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("자동차 이동 횟수 테스트")
    public void carNameInvalidValueTest(String given){
        //when then
        assertThatThrownBy(
                () -> {
                    new CarName(given);
                }
        )
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(ERR_MSG_TITLE);
    }

}