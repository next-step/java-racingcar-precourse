import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    @DisplayName("Car이름이 없거나 5자를 초과했을 때 오류를 출력하는지 테스트")
    void carNameValidation() {
        assertThatThrownBy(() -> new Car("")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Car("123456")).isInstanceOf(IllegalArgumentException.class);
    }
}