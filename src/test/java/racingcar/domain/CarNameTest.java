package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.RacinggameException;

class CarNameTest {

    @Test
    @DisplayName("CarName 생성 확인")
    void createCarName() {
        CarName carName = CarName.from("TEST");

        assertThat(carName.getName()).isEqualTo("TEST");
    }


    @Test
    @DisplayName("CarName이 null일 경우 기대한 예외가 발생하는지 확인")
    void checkCarNameNull() {
        assertThatThrownBy(() -> CarName.from(null))
                .isInstanceOf(RacinggameException.class)
                .hasMessageContaining("[ERROR] The car name cannot be null");
    }

    @Test
    @DisplayName("5글자 이하가 아닌 CarName을 입력할 경우 기대한 예외가 발생하는지 확인")
    void checkCarNameLength() {
        assertThatThrownBy(() -> CarName.from("exception"))
                .isInstanceOf(RacinggameException.class)
                .hasMessageContaining("[ERROR] Check the length of the car name");
    }


    @Test
    @DisplayName("CarName이 공백일 경우 기대한 예외가 발생하는지 확인")
    void checkCarNameEmpty() {
        // then
        assertThatThrownBy(() -> CarName.from(""))
                .isInstanceOf(RacinggameException.class)
                .hasMessageContaining("[ERROR] The car name cannot be empty");
    }
}
