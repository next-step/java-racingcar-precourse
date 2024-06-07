package util;

public class TestRandomNumberGenerator implements IRandomNumberGenerator {
    private int fixedNumber;

    public TestRandomNumberGenerator(int fixedNumber) {
        this.fixedNumber = fixedNumber;
    }

    @Override
    public int generate() {
        return fixedNumber;
    }
}
