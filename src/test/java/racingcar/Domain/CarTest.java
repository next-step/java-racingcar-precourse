package racingcar.Domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @DisplayName("자동차는 이름을가진다.")
    @Test
    void set_car_name() {
        Car car = new Car("shin");
        assertThat(car.getCarName()).isEqualTo("shin");
    }

    @DisplayName("자동차 값이 4이상 이면 전진")
    @Test
    void car_can_move() {
        Car car = new Car("aaa");
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("자동차 값이 3이하이면 멈춤")
    @Test
    void car_stop() {
        Car car = new Car("aaa");
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }


    @DisplayName("우승자")
    @Test
    void is_winner() {
        Car car = new Car("aaaa", 4);
        car.comparePosition(4);
        assertTrue(car.isWinner());
    }
}
