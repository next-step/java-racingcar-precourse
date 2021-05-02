package racing;

import java.util.Random;

public class EnergyGenerator {
    public Energy generate() {
        return new Energy(new Random().nextInt(Energy.ENERGY_BOUND));
    }
}
