package racingcar;

import java.util.Objects;

public class Engine {
    private final Energy energyGauge;

    public Engine(final int energyGauge) {
        this.energyGauge = new Energy(energyGauge);
    }


    public boolean isWorking(final Energy input) {
        if (Objects.isNull(input)) {
            throw new IllegalArgumentException("[ERROR] input must is not null");
        }
        return input.compareTo(energyGauge) >= 0;
    }
}
