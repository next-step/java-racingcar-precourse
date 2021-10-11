package racinggame.model;

import racinggame.exception.ValidationException;

public class Round {
    private final int round;

    public Round(String round) {
        if (!validateRound(round)) {
            throw new ValidationException();
        }
        this.round = Integer.parseInt(round);
    }

    public int getRound() {
        return round;
    }

    private boolean validateRound(String round) {
        return round.matches("^[0-9]{1}$");
    }

}
