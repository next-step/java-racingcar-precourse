package racinggame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

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
