package util;

public class RandomNumberGenerator {

    public int generate(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException(GeneralExceptionMessage.INVALID_MIN_MAX.getMessage());
        }

        return (int) (Math.random() * (max - min + 1)) + min;
    }
}
