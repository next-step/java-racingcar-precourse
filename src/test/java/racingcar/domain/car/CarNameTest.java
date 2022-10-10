package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarName;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {

    @Test
    @DisplayName("자동차 이름을 생성한다.")
    void test_createCarName() {
        //given
        String name = "car";

        //when
        CarName carName = CarName.createCarName(name);

        //then
        assertThat(carName.getCarName()).isEqualTo(name);
    }

    @Test
    @DisplayName("자동차의 이름이 5자 초과라면 IllegalArgumentException을 반환한다.")
    void validCarName() {
        //given
        String carName = "5자_이상인_이름";

        //when then
        assertThatThrownBy(() -> Car.createCar(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 5자 이하만 가능합니다.");
    }
}
