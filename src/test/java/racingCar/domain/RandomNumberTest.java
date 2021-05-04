package racingCar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RandomNumberTest {

    @DisplayName("10보다 크면 예외처리")
    @Test
    void create() {
        assertThatThrownBy(() -> new RandomNumber(10)).isInstanceOf(IllegalArgumentException.class);
    }


}
