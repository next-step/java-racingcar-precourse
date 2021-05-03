package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    @DisplayName("전진")
    void move() {
        Car car = new Car();
        assertThat(car.moveForward()).isEqualTo(1);
    }

    @Test
    @DisplayName("멈춤")
    void stop() {
        Car car = new Car();
        assertThat(car.stop()).isEqualTo(0);
    }
}
