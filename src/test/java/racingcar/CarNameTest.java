package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static racingcar.Constants.NAME_LENGTH_EXCESS_EXCEPTION_MESSAGE;

public class CarNameTest {

    @Test
    void 생성() {
        CarName carName = new CarName("yul");
        assertThat(carName.getValue()).isEqualTo("yul");
    }

    @Test
    void 생성_예외() {
        assertThatThrownBy(() -> {
            CarName carName = new CarName("yul123");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NAME_LENGTH_EXCESS_EXCEPTION_MESSAGE);
    }
}
