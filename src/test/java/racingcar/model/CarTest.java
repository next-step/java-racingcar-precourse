package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    @Test
    void defaultCar() {
        Car actual = new Car("name");
        Car expected = new Car("name", new Spot());
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void carNameOverThan5ThrowException() {
        assertThatThrownBy(() -> new Car("abcdef")).isInstanceOf(IllegalArgumentException.class);
    }
}
