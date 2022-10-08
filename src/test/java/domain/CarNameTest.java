package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarNameTest {

    @Test
    @DisplayName("자동차_이름_검증")
    void 자동차_이름_검증() {
        assertThat(CarName.validate("a")).isTrue();
        assertThat(CarName.validate("abced")).isTrue();

        assertThatThrownBy(() -> new CarName(""))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new CarName("abcdef"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
