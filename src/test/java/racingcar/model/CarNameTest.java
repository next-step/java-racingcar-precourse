package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.common.ErrorMessage.NAME_TO_LONG;

public class CarNameTest {

    @Test
    @DisplayName("자동차 이름 생성 테스트")
    void carNameTest() {
        String test = "test";
        CarName carName = new CarName(test);
        assertThat(carName.getName()).isEqualTo(test);
    }

    @Test
    @DisplayName("자동차 이름 5자 초과 테스트")
    void carNameTooLongTest() {
        String tooLongName = "testCa";
        assertThatIllegalArgumentException()
                .isThrownBy(()->new CarName(tooLongName))
                .withMessage(NAME_TO_LONG.text());
    }

}