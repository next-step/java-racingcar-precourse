package racingcar.generator.random.service.dto;

public class RandomNumberGenerateCommand {

    private final int startInclusive;
    private final int endInclusive;

    public RandomNumberGenerateCommand(int startInclusive, int endInclusive) {
        this.startInclusive = startInclusive;
        this.endInclusive = endInclusive;
    }

    public int getStartInclusive() {
        return startInclusive;
    }

    public int getEndInclusive() {
        return endInclusive;
    }
}
