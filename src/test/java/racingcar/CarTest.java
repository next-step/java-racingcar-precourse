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

    @Test
    @DisplayName("포지션 비교 - 패배")
    void compare_less() {
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");

        car2.move();

        assertThat(car1).isLessThan(car2);
    }

    @Test
    @DisplayName("포지션 비교 - 무승부")
    void compare_equal() {
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");

        car1.move();
        car2.move();

        assertThat(car1).isEqualByComparingTo(car2);
    }

    @Test
    @DisplayName("포지션 비교 - 승리")
    void compare_win() {
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");

        car1.move();

        assertThat(car1).isGreaterThan(car2);
    }
}
