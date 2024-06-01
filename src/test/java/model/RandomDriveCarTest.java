package model;

import static org.assertj.core.api.Assertions.*;

import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomDriveCarTest {

    @Test
    @DisplayName("임의의 수가 4 이상인 경우 전진")
    void driveAndAdvance() {
        // given
        Random fixedRandom = new FixedRandom(4);
        Car car = new RandomDriveCar("testCar", fixedRandom);

        // when
        String state = car.drive();

        // then
        assertThat(state).isEqualTo("-");
    }

    @Test
    @DisplayName("임의의 수가 4 미만인 경우 정지")
    void driveAndStop() {
        // given
        Random fixedRandom = new FixedRandom(3);
        Car car = new RandomDriveCar("testCar", fixedRandom);

        // when
        String state = car.drive();

        // then
        assertThat(state).isEqualTo("");
    }


    private static class FixedRandom extends Random {

        private final int fixedNumber;

        private FixedRandom(int fixedNumber) {
            this.fixedNumber = fixedNumber;
        }

        @Override
        public int nextInt(int bound) {
            return fixedNumber;
        }
    }
}