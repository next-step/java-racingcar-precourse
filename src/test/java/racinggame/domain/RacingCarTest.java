package racinggame.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarTest {

    @DisplayName("자동차를 생성할 수 있다.")
    @Test
    void create() {
        assertDoesNotThrow(
            () -> new RacingCar(new Name("lewis"))
        );
    }
}
