package racingcar.domain.car;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void Car_셋팅() {
        Car car = new Car("woni");
        assertThat(car).isEqualTo(new Car("woni", 0));
    }

    @Test
    void 자동차_이동() {
        Car car = new Car("woni");
        car.play(true);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차_이동_안함() {
        Car car = new Car("woni");
        car.play(false);

        assertThat(car.getPosition()).isEqualTo(0);
    }

}
