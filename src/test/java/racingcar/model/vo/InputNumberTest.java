package racingcar.model.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class InputNumberTest {

    @Test
    @DisplayName("게임진행_횟수_검증")
    void inputNameValidate() {
        assertThatThrownBy(
                () -> new InputNumber("a")
        ).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(
                () -> new InputNumber(" ")
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
