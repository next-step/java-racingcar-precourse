package racingcar;

public class RacingConfig {
    private static final Energy defaultEnergyGauge = new Energy(4);
    private static final int MIN_RANDOM = 0;
    private static final int MAX_RANDOM = 9;

    public static Energy getDefaultEnergyGauge() {
        return defaultEnergyGauge;
    }

    public static int getMinRandom() {
        return MIN_RANDOM;
    }

    public static int getMaxRandom() {
        return MAX_RANDOM;
    }
}
