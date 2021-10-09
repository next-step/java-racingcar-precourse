package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    @DisplayName("자동차 만들기")
    void createCar() {
        //given
        final Car car = Car.of(CarName.of("씽씽이"));
        //then
        assertThat(car.getCarName().getName()).isEqualTo("씽씽이");
    }

    @Test
    @DisplayName("이름이 5글자가 넘어가면 예외 발생")
    void createCar_fail1() {
        //given && then
        assertThatThrownBy(() -> Car.of(CarName.of("가나다라마바")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.NAME_EXCEEDED.getMessage());
    }

    @Test
    @DisplayName("이름이 공백이거나 null이면 예외 발생")
    void createCar_fail2() {
        //given && then
        assertThatThrownBy(() -> Car.of(CarName.of("")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.NAME_NOT_BLANK.getMessage());

    }
}
