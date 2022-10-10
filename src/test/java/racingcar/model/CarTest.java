package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.strategy.AlwaysMove;

class CarTest {

    @Test
    void 자동차_이름_길이_예외_처리() {
        assertThatThrownBy(() -> {
            new Car("test1234", new AlwaysMove());
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_전진() {
        Car car = new Car("test", new AlwaysMove());
        car.move();

        assertThat(car.getDistance()).isEqualTo(1);
    }
}