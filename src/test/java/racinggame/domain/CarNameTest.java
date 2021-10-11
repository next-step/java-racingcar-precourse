package racinggame.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarNameTest {
    @Test
    @DisplayName("자동차의 이름은 1자 이상, 5자 이하여야 한다.")
    void 자동차_이름_부여_참() {
        CarName carName1 = new CarName("자");
        CarName carName2 = new CarName("자동차이름");

        assertThat(carName1.getIsValid()).isTrue();
        assertThat(carName2.getIsValid()).isTrue();
    }

    @Test
    @DisplayName("자동차의 이름은 1자 이상, 5자 이하여야 한다.")
    void 자동차_이름_부여_거짓() {
        CarName carName1 = new CarName(null);
        CarName carName2 = new CarName("");
        CarName carName3 = new CarName("자동차이름2");

        assertThat(carName1.getIsValid()).isFalse();
        assertThat(carName2.getIsValid()).isFalse();
        assertThat(carName3.getIsValid()).isFalse();
    }
}
