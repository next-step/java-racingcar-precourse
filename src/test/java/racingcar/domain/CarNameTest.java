package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.constant.Message;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarNameTest {

    @DisplayName("자동차 이름은 5글자 이내여야 한다. - 정상 케이스")
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "woni", "jun"})
    void createCarNameTest1(String input) {
        CarName carName = new CarName(input);
        assertThat(carName.getName()).isEqualTo(input);
    }

    @DisplayName("자동차 이름은 5글자 이내여야 한다. - 오류 케이스")
    @ParameterizedTest
    @ValueSource(strings = {"", "racingcar", "eunkyoung"})
    void createCarNameTest2(String input) {
        assertThatThrownBy(() -> new CarName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Message.ERR_NAME_LEN);
    }
}