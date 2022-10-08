package racingcar.model;

import racingcar.util.Message;

public class Round {
    private final int round;

    public Round(String round) {
        try {
            this.round = Integer.parseInt(round);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.ERROR_ONLY_NUMBERS.getMessage());
        }

        if(this.round < 1) {
            throw new IllegalArgumentException(Message.ERROR_MORE_THAN_ONE.getMessage());
        }
    }

    public int getRound() {
        return round;
    }
}
