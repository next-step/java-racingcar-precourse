package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("자동차 이동 명령이 지정한 거리만큼만 이동하는지 테스트")
    public void car_ShouldMove_MovingDistance() {
        Car car = new Car("테스트자동차");
        //when
        car.move();
        //then
        assertThat(car.getLocation()).isEqualTo(Car.MOVING_DISTANCE);
    }

}
