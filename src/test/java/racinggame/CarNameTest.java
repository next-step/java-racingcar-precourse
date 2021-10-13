package racinggame;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {

    @Test
    public void carName_length_test() {
        assertThatThrownBy(() -> new CarName("123456")).isInstanceOf(IllegalArgumentException.class);
    }
}
