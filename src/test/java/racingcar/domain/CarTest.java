package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("자동차 초기화 정상 수행여부를 확인한다.")
    void initTest() {
        // given
        String carNameString = "테스트1";

        // when
        Car car = Car.create(
                CarName.from(carNameString)
        );

        //then
        assertThat(car.getCarName()).as("차 이름이 정상 반영되는지 확인")
                .isEqualTo(carNameString);
        assertThat(car.getPosition()).as("차 위치가 0으로 초기화 되었는지 확인")
                .isEqualTo(CarPosition.CAR_START_POSITION);
    }

    @ParameterizedTest(name = "자동차 이동 시 악셀 파워에 따라 위치가 정상적으로 변경되었는지 확인한다. [악셀 파워: {0}, 이동 여부: {1}]")
    @CsvSource(value = {
            "0,false",
            "1,false",
            "2,false",
            "3,false",
            "4,true",
            "5,true",
            "6,true",
            "7,true",
            "8,true",
            "9,true",
    })
    void moveTest(int power, boolean isMoved) {
        // given
        Car car = Car.create(CarName.from("car1"));

        // when
        car.moveByAccelPower(AccelPower.from(power));

        //then
        assertThat(car.getPosition() == Car.CAR_POSITION_INCREASE_UNIT).as("자동차 위치가 증가 했는지 여부 확인")
                .isEqualTo(isMoved);

    }
}
