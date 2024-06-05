package util;

public class TestRandomNumberGenerator implements ITestRandomNumberGenerator{
    private int fixedNumber;

    public TestRandomNumberGenerator(int fixedNumber) {
        this.fixedNumber = fixedNumber;
    }

    @Override
    public int generate() {
        return fixedNumber;
    }
}
