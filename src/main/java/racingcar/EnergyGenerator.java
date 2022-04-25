package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class EnergyGenerator {
    private final int min;
    private final int max;
    public EnergyGenerator(final int min, final int max) {
        validation(min, max);
        this.min = min;
        this.max = max;
    }

    private void validation(final int min , final int max) {
        if (min >= max) {
            throw new IllegalArgumentException("[ERROR] invalid ranges");
        }
    }
    public Energy create() {
        return validNumber();
    }

    private Energy validNumber() {
        final int outputNumber = pickNumberInRange(this.min, this.max);
        if (this.min <= outputNumber && outputNumber <= this.max) {
            return new Energy(outputNumber);
        }
        throw new IllegalStateException("[ERROR] pickNumberInRange Error");
    }
}
