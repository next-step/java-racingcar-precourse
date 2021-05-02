package racing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EnergyTest {

    @Test
    void construct_shouldThrowWhenGreaterLevel() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Energy(Energy.ENERGY_BOUND));
    }

    @Test
    void construct_shouldThrowWhenNegativeLevel() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            int negativeLevel = -1;
            new Energy(negativeLevel);
        });
    }
}
