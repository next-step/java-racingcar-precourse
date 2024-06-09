package racingcar;

import main.java.racingcar.domain.Car;
import main.java.racingcar.domain.CarName;
import main.java.racingcar.message.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("자동차 이름 생성 성공 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"a", "jin", "a2", "abcd", "12345"})
    void CarNameSuccessTest(String name) {
        Car car = new Car(new CarName(name));
        assertThat(car.getName()).isEqualTo(name);
    }

    @DisplayName("자동차 이름 생성 실패 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"", "        ", "5자를넘는이름테스트", "123456"})
    void CarNameFailTest(String name) {
        Assertions.assertThatThrownBy(() ->{
            new Car(new CarName(name));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_CAR_NAME);
    }
}
