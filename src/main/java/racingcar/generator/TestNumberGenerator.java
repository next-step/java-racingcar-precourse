package racingcar.generator;

public class TestNumberGenerator implements NumberGenerator {

    private final Integer testNumber;

    public TestNumberGenerator(Integer testNumber) {
        this.testNumber = testNumber;
    }

    @Override
    public Integer generate() {
        return this.testNumber;
    }
}
