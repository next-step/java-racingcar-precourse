package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.CarName;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {

    @Test
    public void create_carName_test() {
        CarName carName = new CarName("car");
        assertThat(carName).isEqualTo(new CarName("car"));
    }

    @Test
    public void carName_length_test() {
        assertThatThrownBy(() -> new CarName("longName")).isInstanceOf(IllegalArgumentException.class);
    }
}
