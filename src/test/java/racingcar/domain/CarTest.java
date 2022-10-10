package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("Car 클래스를 생성한다.")
    @Test
    void construct() {
        Car car = new Car("car1", 1);
        assertThat(car).isNotNull();
    }

    @DisplayName("Car 클래스의 equals 메소드의 정상동작을 확인한다.")
    @Test
    void equals() {
        Car car = new Car("car1", 1);
        assertThat(car).isEqualTo(new Car("car1", 1));
    }
}
