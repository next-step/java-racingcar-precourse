package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {
    @Test
    @DisplayName("차의 이름이 5글자 초과이면 예외가 발생한다.")
    void carNameLengthMustBeUnderFive() {
        String testerName = "polymorph";
        assertThatThrownBy(() -> CarName.createCarName(testerName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
