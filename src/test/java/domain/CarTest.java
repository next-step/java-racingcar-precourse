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
        assertThat(car.movable(4)).isEqualTo(1);
        assertThat(car.movable(5)).isEqualTo(2);
        assertThat(car.movable(6)).isEqualTo(3);
        assertThatThrownBy(() -> {
            car.movable(10);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("멈춤")
    void stop() {
        Car car = new Car("dummy");
        assertThat(car.movable(3)).isEqualTo(0);
        assertThat(car.movable(2)).isEqualTo(0);
        assertThat(car.movable(1)).isEqualTo(0);
        assertThat(car.movable(7)).isEqualTo(1);
        assertThat(car.movable(1)).isEqualTo(1);
        assertThat(car.movable(2)).isEqualTo(1);
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
