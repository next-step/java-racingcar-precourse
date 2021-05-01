package racing;

import java.util.Random;

public class EnergyGenerator {
    public static Energy generate() {
        return new Energy(new Random().nextInt(Energy.ENERGY_BOUND));
    }
}
