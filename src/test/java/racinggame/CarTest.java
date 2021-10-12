package racinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racinggame.domain.Car;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {
    Car car;

    @BeforeEach
    void init() {
        car = new Car("ryu");
    }

    @Test
    void 차_생성() {
        assertAll(
                () -> assertThat(car.getPosition()).isEqualTo(0),
                () -> assertThat(car.getCarName()).isEqualTo("ryu"));
    }

    @Test
    void 차_생성_오류() {
        assertThatThrownBy(() ->
                new Car("testtt"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 차_전진() {
        car.move(() -> true);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 차_멈춤() {
        car.move(() -> false);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
