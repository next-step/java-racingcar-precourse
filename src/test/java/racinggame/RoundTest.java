package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.model.Car;
import racinggame.model.Round;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class RoundTest {
    @DisplayName("잘못된 파라미터 전달")
    @Test
    void checkRoundIllegalArgument() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new Round("hello"));
    }

}
