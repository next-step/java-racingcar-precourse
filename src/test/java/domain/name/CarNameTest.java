package domain.name;

import domain.name.CarName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class CarNameTest {
    @ParameterizedTest
    @ValueSource(strings = {"123456","1234567","12345678"})
    @DisplayName("자동차의 이름은 5글자를 넘어서는 안된다")
    public void 자동차의_이름은_5글자를_넘어서는_안된다(String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> new CarName(name));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "12", "123", "1234", "12345"})
    @DisplayName("자동차의 이름은 5이하여야 한다")
    public void 자동차의_이름은_5이하여야_한다(String name) {
        assertThatNoException().isThrownBy(() -> new CarName(name));
    }
}
