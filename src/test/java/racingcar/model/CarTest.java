package racingcar.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import racingcar.ui.CarStatus;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    public static Car car;

    @BeforeAll
    static void initAll() {
        car = new Car("carName");
    }

    @Test
    void 자동차_이름_출력() {
        car = new Car("newName");
        assertThat(car.getName()).isEqualTo("newName");
    }

    @Test
    void 자동차_전진() {
        car.addLocation();
        assertThat(car.getLocation()).isEqualTo("-");
        car.addLocation();
        assertThat(car.getLocation()).isEqualTo("--");
    }

    @Test
    void 자동차_전진여부_설정() {
        car.setStatus(CarStatus.MOVE);
        assertThat(car.getStatus()).isEqualTo(CarStatus.MOVE);
        car.setStatus(CarStatus.STOP);
        assertThat(car.getStatus()).isEqualTo(CarStatus.STOP);
    }
}