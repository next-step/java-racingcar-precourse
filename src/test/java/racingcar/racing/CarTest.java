package racingcar.racing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @Test
    void 자동차는_이동시_4_이상이면_움직이고_미만이면_움직이지_않는다() {
        Car car = new Car("foo");

        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0);

        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }
}