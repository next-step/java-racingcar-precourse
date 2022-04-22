package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    Car car;

    @BeforeEach
    public void before() {
        car  = new Car(new CarName("test"));
    }

    @Test
    public void 이동1회_toString검증() {
        car.movePosition();
        assertThat(car.getPositionValue()).isEqualTo(1);
        assertThat(car.carStatus()).isEqualTo("test : -");
    }

    @Test
    public void 이동2회_toString검증() {
        car.movePosition();
        car.movePosition();
        assertThat(car.getPositionValue()).isEqualTo(2);
        assertThat(car.carStatus()).isEqualTo("test : --");
    }

    @Test
    public void 이동3회_toString검증() {
        car.movePosition();
        car.movePosition();
        car.movePosition();
        assertThat(car.getPositionValue()).isEqualTo(3);
        assertThat(car.carStatus()).isEqualTo("test : ---");
    }

    @Test
    public void 이동4회_toString검증() {
        car.movePosition();
        car.movePosition();
        car.movePosition();
        car.movePosition();
        assertThat(car.getPositionValue()).isEqualTo(4);
        assertThat(car.carStatus()).isEqualTo("test : ----");
    }
}
