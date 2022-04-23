package racingcar.racing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {

    @Test
    void 자동차는_이름을_입력받을_수_있으며_5자_이하여야_한다() {
        assertThat(new CarName("12345")).isNotNull();
        assertThatThrownBy(() -> new CarName("123456")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름은_빈_값을_허용하지_않는다() {
        assertThatThrownBy(() -> new CarName("   ")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new CarName("")).isInstanceOf(IllegalArgumentException.class);
    }
}