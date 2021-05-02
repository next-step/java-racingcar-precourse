package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("차 전진")
    void moveTest() {
        Car car = new Car();
        assertThat(car.isMovable(4)).isTrue();
        assertThat(car.isMovable(3)).isFalse();
    }

    @ParameterizedTest
    @DisplayName("차 위치 출력")
    @CsvSource({"'pobi', 3, 'pobi:---'",
                "'crong', 0, 'crong:'"})
    void printPosition(String name, int move, String result) {
        Car car = new Car(name);

        for (int i = 0; i < move; i++) {
            car.move();
        }

        assertThat(car.toString()).isEqualTo(result);
    }

    @Test
    @DisplayName("랜덤한 숫자 뽑기")
    void draw() {
        Car car = new Car();
        assertThat(car.draw()).isBetween(0, 9);
    }
}
