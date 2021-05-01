package domain;

import constant.CarRule;
import constant.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    @DisplayName("자동차 이동 명령이 지정한 거리만큼만 이동하는지 테스트")
    public void car_ShouldMove_MovingDistance() {
        Car car = new Car("테스트자동차");
        //when
        car.move();
        //then
        assertThat(car.getLocation()).isEqualTo(CarRule.MOVING_DISTANCE_PER_MOVE);
    }

    @Test
    @DisplayName("자동차의 이름이 제한 글자 수를 초과할 경우 예외를 발생시키는지 테스트")
    public void ifCarNameOverNameLengthLimit_ShouldThrowIllegalArgumentException() {
        String carName = createCarNameOverLimit();
        assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.CAR_NAME_LENGTH_LIMIT_EXCEPTION);
    }

    private String createCarNameOverLimit() {
        String carName = "a";
        for (int i = 0; i < CarRule.NAME_LENGTH_LIMIT; i++) {
            carName += "a";
        }
        return carName;
    }

}
