package racingcar.domain;

public class Threshold {

    private final int thresholdInclusive;

    public Threshold(int thresholdInclusive) {
        this.thresholdInclusive = thresholdInclusive;
    }

    public boolean isAbove(int other) {
        return other > thresholdInclusive;
    }

    public boolean isAboveOrEqualTo(int other) {
        return other >= thresholdInclusive;
    }
}
