package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {
    @Test
    @DisplayName("자동차의 이름을 설정 한다.")
    void set_car_name() {
        Car car = new Car("kkobi");
        assertThat(car).isNotNull();
    }

    @Test
    @Disabled
    @DisplayName("자동차의 이름은 5자리 이하만 가능하다.")
    void exception_set_car_name() {
        assertThatThrownBy(() -> {
            Car car = new Car("kkobi2");
        }).isInstanceOf(IllegalArgumentException.class);

    }
}
