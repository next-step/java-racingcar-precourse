package racing;

public class Round {
    private static final int MIN_ROUND = 1;
    private static final int MAX_ROUND = 10;
    private int round;

    public Round(int round) {
        validateRound(round);
        this.round = round;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;

        if (other == null || getClass() != other.getClass())
            return false;

        Round obj = (Round) other;
        return round == obj.round;
    }

    private void validateRound(int input) {
        if (input < MIN_ROUND)
            throw new IllegalArgumentException("Round should be greater than" + MIN_ROUND);
        if (input > MAX_ROUND)
            throw new IllegalArgumentException("Round should be less than" + MAX_ROUND);
    }
}
