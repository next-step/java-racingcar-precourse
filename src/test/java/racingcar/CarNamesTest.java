package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNamesTest {

    @Test
    @DisplayName("차 이름들이 중복되면 예외가 발생한다.")
    void carNameLengthMustBeUnderFive() {
        String userInput = "ploy,morp1,morp1,morp3";
        assertThatThrownBy(() -> CarNames.getCarNamesFromInput(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
