package racingcar.car;

import org.junit.jupiter.api.Test;
import racingcar.ErrorMessage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {

    @Test
    void 자동차_이름_길이를_벗어날_경우() {
        assertThatThrownBy(() -> new CarName("123456"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.CAR_NAME_OVER_LENGTH);
    }

    @Test
    void 자동차_이름이_빈값일_경우() {
        assertThatThrownBy(() -> new CarName(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.CAR_NAME_EMPTY);
    }

    @Test
    void 쉼표_기준_차량_이름_분리_기능_검증() {
        String testInput = "k5,bongo,k3";
        assertThat(CarName.splitInputCarNames(testInput).size()).isEqualTo(3);
        assertThat(CarName.splitInputCarNames(testInput).get(0).toText()).isEqualTo("k5");
    }
}
