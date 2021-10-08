package racinggame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Car: 경주 게임에 사용되는 자동차")
public class CarTest {

    @DisplayName("0 ~ 3 값이면 멈추고 4 ~ 9 값이면 전진")
    @ParameterizedTest
    @CsvSource(value = {
            "0, 0, ''",
            "1, 0, ''",
            "2, 0, ''",
            "3, 0, ''",
            "4, 1, -",
            "5, 1, -",
            "6, 1, -",
            "7, 1, -",
            "8, 1, -",
            "9, 1, -"
    })
    void testGoAndStop(int moveValue, int distance, String road) {
        String name = "audi";
        Car car = new Car(name);

        car.move(new MoveCondition(moveValue));

        assertThat(car.getPosition()).isEqualTo(distance);
        assertThat(car.getName()).isEqualTo(name);
        assertThat(car.getRoad()).isEqualTo(road);
    }
}
