package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarNameTest {
    @Test
    void testValidation() {
        assertThatIllegalArgumentException().isThrownBy(() -> new CarName(null));
        assertThatIllegalArgumentException().isThrownBy(() -> new CarName(""));
        // 이름은 5자 이하만 가능
        assertThatIllegalArgumentException().isThrownBy(() -> new CarName("012345"));
    }

    @Test
    void testToString() {
        CarName carName = new CarName("pobi");
        assertThat(carName.toString()).isEqualTo("pobi");
    }
}
