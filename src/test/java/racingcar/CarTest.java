package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("이름, 위치 출력")
    void CarToString() {
        Car car = new Car("name");
        car.move(4);
        car.move(5);
        assertThat(car.toString()).isEqualTo("name : --");
    }

    @Test
    @DisplayName("위치 전진")
    void carMoveForward() {
        Car car = new Car("name");
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(new Position(1));
    }
}
