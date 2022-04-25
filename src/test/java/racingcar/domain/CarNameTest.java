package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarNameTest {
    @Test
    void 자동차_이름_5자_초과() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            CarName carName = new CarName("abcdef");
        });
    }

    @Test
    void 자동차_이름_1자_미만() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            CarName carName = new CarName("");
        });
    }
}