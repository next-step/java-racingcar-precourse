package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarMoveTest {
    Car car;

    @BeforeEach
    void setup(){
        car = new Car();
    }

    @Test
    @DisplayName("랜덤값이 4이상 이면 전진")
    void move_car() {
        assertThat(car.move(4)).isEqualTo(1);
    }

    @Test
    @DisplayName("랜덤값이 3이상 이하면 멈춤")
    void stop_car() {
        assertThat(car.move(3)).isEqualTo(0);
    }

    @Test
    @DisplayName("랜덤값이 0~9 범위가 아닌 경우는 전진하지 않는다.")
    void exception_case() {
        Assertions.assertAll(
                () -> assertThat(car.move(-1)).isEqualTo(0),
                () -> assertThat(car.move(10)).isEqualTo(0)
        );

    }
}
