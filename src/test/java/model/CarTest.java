package model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class CarTest {

    @Test
    public void 자동차_생성_테스트() {
        Car car = new Car("pobi");
        assertThat(car.getName()).isEqualTo("pobi");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    public void 자동차_이름_길이_초과_예외_테스트() {
        assertThatThrownBy(() -> new Car("overfive"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 자동차 이름은 5자 이하여야 합니다.");
    }

    @Test
    public void 자동차_전진_테스트() {
        Car car = new Car("pobi");
        car.move(true);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    public void 자동차_멈춤_테스트() {
        Car car = new Car("pobi");
        car.move(false);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
