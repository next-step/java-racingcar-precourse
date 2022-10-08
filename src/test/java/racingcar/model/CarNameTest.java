package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.enums.ErrorType;

import static org.junit.jupiter.api.Assertions.*;

class CarNameTest {

    @Test
    @DisplayName("자동차의 이름이 5글자를 넘으면 오류를 리턴한다.")
    void userNameOverFail() {
        Assertions.assertThatThrownBy(() -> {
                    new CarName("가나다라마바");
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorType.INVALID_INPUT_CAR_NAME.getMessage());
    }

    @Test
    @DisplayName("자동차의 이름이 0글자를 넘지 않으면 오류를 리턴한다.")
    void userNameUnderFail() {
        Assertions.assertThatThrownBy(() -> {
                    new CarName("");
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorType.INVALID_INPUT_CAR_NAME.getMessage());
    }

    @Test
    @DisplayName("자동차의 이름을 성공적으로 생성한다.")
    void userNameSuccess() {
        String inputName = "가나다라";

        CarName carName = new CarName(inputName);

        assertEquals(carName.getName(), inputName);
    }
}