package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @DisplayName("자동차 일괄 출고")
    @Test
    void releaseCars() {
        // given & when
        String carNames = "mrlee,jplee,pobi";
        Cars cars = Cars.release(carNames);

        // then
        assertThat(cars.getCars().size()).isEqualTo(3);
        assertThat(cars.getCars().get(0).getCarName()).isEqualTo("mrlee");
        assertThat(cars.getCars().get(1).getCarName()).isEqualTo("jplee");
        assertThat(cars.getCars().get(2).getCarName()).isEqualTo("pobi");
    }

    @DisplayName("좌표가 찍혀, 자동차가 이동 시 position이 변경되어야한다.")
    @Test
    void moveCars() {
        // given
        String carNames = "mrlee,jplee,pobi";
        Cars cars = Cars.release(carNames);
        Coordinates coordinates = Coordinates.generate(3, 4, 5);

        // when
        cars.move(coordinates);

        // then
        assertThat(cars.getCars().get(0).getPosition()).isEqualTo(0);
        assertThat(cars.getCars().get(1).getPosition()).isEqualTo(1);
        assertThat(cars.getCars().get(2).getPosition()).isEqualTo(1);
    }
}
