package domain;

import constant.CarRule;
import constant.ExceptionMessage;
import dto.CarDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CarTest {

    @Test
    @DisplayName("자동차 이동 명령이 지정한 거리만큼만 이동하는지 테스트")
    public void car_ShouldMove_MovingDistance() {
        Car car = new Car("테스트자동차");
        //when
        car.move();
        //then
        CarDto carDto = car.toDto();
        assertThat(carDto.getLocation()).isEqualTo(CarRule.MOVING_DISTANCE_PER_MOVE);
    }

    @Test
    @DisplayName("자동차의 이름이 제한 글자 수를 초과할 경우 예외를 발생시키는지 테스트")
    public void ifCarNameOverNameLengthLimit_ShouldThrowIllegalArgumentException() {
        //given
        String carName = createCarNameOverLimit();
        //when, then
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

    @Test
    @DisplayName("자동차가 , 로 구분지어 생성되는지 테스트")
    public void generateCars_ShouldBeSeparate_AtSeperator() {
        //given
        String carNames = "차1,차2,차3";
        //when
        Cars cars = CarsGenerator.generate(carNames);
        //then
        List<CarDto> carDtos = cars.getCarDtos();
        assertAll(
                () -> assertThat(carDtos.get(0).getName()).isEqualTo("차1"),
                () -> assertThat(carDtos.get(1).getName()).isEqualTo("차2"),
                () -> assertThat(carDtos.get(2).getName()).isEqualTo("차3"));

    }

}
