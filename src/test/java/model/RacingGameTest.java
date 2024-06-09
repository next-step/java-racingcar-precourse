package model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @Test
    void 랜덤값이_4_이상() {
        int randomNumber = 5;
        Car car = new Car("test");
        int position = car.getPosition();
        car.move(randomNumber);
        assertThat(car.getPosition()).isEqualTo(position + 1);
    }

    @Test
    void 랜덤값이_4_미만() {
        int randomNumber = 3;
        Car car = new Car("test");
        int position = car.getPosition();
        car.move(randomNumber);
        assertThat(car.getPosition()).isEqualTo(position);
    }
}