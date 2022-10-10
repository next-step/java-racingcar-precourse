package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarStatusTest {
    @Test
    void stopOrGoTest() {
        int carStatusNum = CarStatus.stopOrGo().ordinal();
        assertTrue(carStatusNum >= 0 && carStatusNum <= 1);
    }
}
