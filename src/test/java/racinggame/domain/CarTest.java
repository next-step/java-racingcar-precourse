package racinggame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void status_테스트() {
        Car car = new Car("퐁당퐁당");
        car.move(5);
        assertThat(car.status()).contains("퐁당퐁당 : -");
    }
}
