package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarTest {

    @Test
    void 자동차가_움직인다() {

        // given
        Car car = new Car("pobi", new CarPosition());

        // when
        car.move(4);

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차가_정지한다() {

        // given
        Car car = new Car("pobi", new CarPosition());

        // when
        car.move(0);

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }
}