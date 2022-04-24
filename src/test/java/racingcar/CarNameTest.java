package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

/**
 * author : citizen103
 */
public class CarNameTest {

    @Test
    void 자동차_이름_길이_Exception_Test() {
        // When && Then
        assertThatThrownBy(() -> {
            new CarName("abcdefg");
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 이름은 5자 이하만 가능합니다.");
    }

}
