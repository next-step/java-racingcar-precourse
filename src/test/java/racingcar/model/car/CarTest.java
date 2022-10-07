package racingcar.model.car;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarTest {
    @Test
    void CAR_생성_테스트_정상() {
        Car car = new Car();

        assertThatNoException().isThrownBy(() -> car.setName("Messi"));
    }

    @Test
    void CAR_생성_테스트_이름_5글자_초과() {
        Car car = new Car();

        assertThatThrownBy(() -> car.setName("MyCarIsAvante")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void CAR_이동_테스트() {
        Car car = new Car("Messi");
        car.move();

        assertThat(car.getDistance().getIntDistance()).isEqualTo(1);
        car.move();
        assertThat(car.getDistance().getIntDistance()).isEqualTo(2);
        assertThat(car.getDistance().getStrDistance()).isEqualTo("--");
    }
}
