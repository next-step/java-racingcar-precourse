package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class RacingCarFactoryTest {

    @Test
    @DisplayName("문자열로 자동차 이름을 받았을 때 자동차 생성시 문자열에 해당하는 자동차 갯수만큼 자동차가 생성되었는지 확인")
    void createTest() {

        // given
        String carsName = "grace,mia,violate,terry,jeni";

        // when
        List<RacingCar> cars = RacingCarFactory.create(carsName);

        // then
        assertThat(cars.size()).isEqualTo(carsName.split(",").length);
    }
}
