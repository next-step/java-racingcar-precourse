package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("자동차 목록 테스트")
class CarsTest {
    @Test
    void 자동차_목록_생성() {
        Car car1 = createCar("pobi", 0);
        Car car2 = createCar("woni", 0);
        Car car3 = createCar("jun", 0);

        Cars cars = new Cars(car1, car2, car3);

        assertThat(cars).isEqualTo(new Cars(car1, car2, car3));
    }

    @Test
    void 포지션이_가장_높은_자동차의_포지션을_반환한다() {
        Car car1 = createCar("pobi", 0);
        Car car2 = createCar("woni", 11);
        Car car3 = createCar("jun", 9);
        Cars cars = new Cars(car1, car2, car3);

        assertThat(cars.highestPosition()).isEqualTo(new Position(11));
    }

    @Test
    void 포지션이_같은_자동차_목록을_반환한다() {
        Car car1 = createCar("pobi", 0);
        Car car2 = createCar("woni", 11);
        Car car3 = createCar("jun", 11);
        Cars cars = new Cars(car1, car2, car3);

        assertThat(cars.equalPosition(new Position(11))).isEqualTo(new Cars(car2, car3));
    }

    private Car createCar(final String name, final int position) {
        Name carName = new Name(name);
        Position carPosition = new Position(position);
        return new Car(carName, carPosition);
    }
}
