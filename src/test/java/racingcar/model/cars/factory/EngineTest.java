package racingcar.model.cars.factory;

import static org.assertj.core.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class EngineTest {
    @Test
    void 엔진_작동_값_유효() {
        for (int i = 0; i < 10000; i++) {
            try {
                MoveEventValidator.assertValid(new Engine().run().get());
                assertTrue(Boolean.TRUE);
            } catch (IllegalArgumentException e) {
                fail("Illegal value error occurred.");
            }
        }
    }
}
