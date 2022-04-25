package racingcar;

public class FakeRandomNumberGenerator implements RandomNumberPickable {
    private final int[] numbers;
    private int index;

    public FakeRandomNumberGenerator(final int[] numbers) {
        this.numbers = numbers;
        this.index = 0;
    }

    @Override
    public int pickNumberInRange(int startInclusive, int endInclusive) {
        return numbers[index++];
    }
}
