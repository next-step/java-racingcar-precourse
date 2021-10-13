package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.domain.Car;
import racinggame.domain.CarName;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    @DisplayName("주어진 interval 만큼 Car 이동하였는지 확인")
    @Test
    void moveTest() {
        Car car = new Car(new CarName("TEST"));
        car.move(1);
        assertEquals(1, car.getDistance());

        car.move(5);
        assertEquals(6, car.getDistance());
    }

    @DisplayName("자동차 이름 5자이하인지 확인")
    @Test
    void checkCarNameLength() {
        assertThatThrownBy(() -> new Car(new CarName("TEST_CAR")) )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 자동자 이름은 5글자 이하여야 합니다.");
    }

}
