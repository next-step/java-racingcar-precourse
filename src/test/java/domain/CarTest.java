package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {
    @Test
    @DisplayName("전진")
    void move() {
        Car car = new Car("dummy");
        assertThat(car.moveForward()).isEqualTo(1);
    }

    @Test
    @DisplayName("멈춤")
    void stop() {
        Car car = new Car("dummy");
        assertThat(car.stop()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차 이름부여")
    void name() {
        String bongcar = "bcar";
        Car car = new Car(bongcar);
        assertThat(car.name()).isEqualTo(bongcar);

        assertThatThrownBy(() -> {
            new Car("blabla");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
