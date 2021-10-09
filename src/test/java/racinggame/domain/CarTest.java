package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("전달 받은 이름으로 자동차 이름을 가져올 수 있는지 테스트")
    @Test
    void getName_success() {
        String name = "test";
        Car car = new Car("test");

        assertThat(car.getName()).isEqualTo(name);
    }
}