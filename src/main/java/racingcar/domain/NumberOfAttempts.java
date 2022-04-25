package racingcar.domain;

public class NumberOfAttempts {

    private final int numberOfAttempts;

    public NumberOfAttempts(int numberOfAttempts) {
        this.numberOfAttempts = numberOfAttempts;
    }

    public static NumberOfAttempts of(int numberOfAttempts) {
        return new NumberOfAttempts(numberOfAttempts);
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }
}
