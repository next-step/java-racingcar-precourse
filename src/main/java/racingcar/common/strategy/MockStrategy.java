package racingcar.common.strategy;

public class MockStrategy implements NumberStrategy {

    private final int number;

    public MockStrategy(int number) {
        this.number = number;
    }

    @Override
    public int generate() {
        return number;
    }
}
