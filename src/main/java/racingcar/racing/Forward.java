package racingcar.racing;

public class Forward {
    private final int AVAILABLE_FORWARD_MIN_NUMBER = 4;
    private final int MIN_POSSIBLE_INPUT = 0;
    private final int MAX_POSSIBLE_INPUT = 9;

    private final int forwardNumber;

    public Forward(int forwardNumber) {
        validate(forwardNumber);
        this.forwardNumber = forwardNumber;
    }

    public boolean isAvailableForward() {
        return this.forwardNumber >= AVAILABLE_FORWARD_MIN_NUMBER;
    }

    private void validate(int forwardNumber) {
        if (forwardNumber < MIN_POSSIBLE_INPUT || forwardNumber > MAX_POSSIBLE_INPUT) {
            throw new IllegalArgumentException("Inputs can only be between 0 and 9");
        }
    }
}
