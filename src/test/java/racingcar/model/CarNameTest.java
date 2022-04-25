package racingcar.model;

import org.junit.jupiter.api.Test;
import racingcar.message.ErrorMessage;

import static org.assertj.core.api.Assertions.*;

public class CarNameTest {

    @Test
    void 차_이름_5자_이하_검증() {
        CarName carName = new CarName("abcd");

        assertThat(carName.getName()).isEqualTo("abcd");
    }

    @Test
    void 차이름_5자_초과() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new CarName("491274091390");
        }).withMessageContaining(ErrorMessage.OUT_OF_NAME_LENGTH_ERROR.getMessage());
    }

}
