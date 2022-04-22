package racingcar.domain;

public class RacingGameStep {
    private int value;

    public RacingGameStep(int value) {
        this.value = value;
    }

    public static RacingGameStep from(int value) {
        return new RacingGameStep(value);
    }

    public int getValue() {
        return this.value;
    }
}
