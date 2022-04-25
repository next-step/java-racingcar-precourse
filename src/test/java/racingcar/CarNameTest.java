package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.car.CarName;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {

    @Test
    void carNameLengthFail() {
        assertThatThrownBy(
                () -> CarName.of("superj")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void carNameLengthPass() {
        assertThat(CarName.of("kkj").getCarName()).isEqualTo("kkj");
    }
}
