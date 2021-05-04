package racingCar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    private static final String TEST_CAR = "TEST";

    @DisplayName("자동차 이름이 5글자를 초과하면 예외처리")
    @Test
    void car_length_contrain() {
        assertThatThrownBy(() -> new Car("jdragon", 0))
                .isInstanceOf(ExceedCarNameException.class)
                .hasMessage("자동차 이름의 길이가 5를 초과했습니다.");
    }

    @DisplayName("자동차가 움직이는 경우")
    @Test
    void move_test() {
        Car car = new Car(TEST_CAR, 0);
        car.move(() -> true);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("자동차가 안움직이는 경우")
    @Test
    void not_move_test() {
        Car car = new Car(TEST_CAR, 0);
        car.move(() -> false);
        assertThat(car.getPosition()).isEqualTo(0);
    }

}