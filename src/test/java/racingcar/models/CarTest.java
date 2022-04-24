package racingcar.models;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("자동차는 이름을 가진다.")
    void has_name() {
        String name = "Name";
        Car car = new Car(name);
        assertThat(car.getName()).isEqualTo(name);
    }

}
