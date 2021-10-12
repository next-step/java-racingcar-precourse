package racinggame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    @Test
    void 차_생성() {
        Car car = new Car("ryu");
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
}
