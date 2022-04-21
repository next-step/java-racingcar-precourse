package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarNamesTest {

    @Test
    @DisplayName("자동차_이름_입력값_검증")
    void 자동차_이름_입력값_검증() {
        assertThatThrownBy(() -> new CarNames(""))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
