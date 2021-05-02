package racing;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class EnergyGeneratorTest {

    @Test
    void generate_shouldGenerateEnergy() {
        Energy energy = new EnergyGenerator().generate();

        assertThat(energy.getLevel()).isLessThan(Energy.ENERGY_BOUND);
    }

    @Test
    void generate_shouldGenerateRandomEnergy() {
        EnergyGenerator generator = new EnergyGenerator();

        Set<Energy> actual = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            Energy energy = generator.generate();
            actual.add(energy);
        }

        assertThat(actual.size()).isEqualTo(Energy.ENERGY_BOUND);
    }
}
