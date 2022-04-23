package racingcar.model;

import racingcar.model.error.ErrorMessage;

import java.util.Objects;

public class Round {

    private final int round;
    private static final String NUMBER_REGEX = "-?(0|[1-9]\\d*)";
    private static final int MIN_NUMBER = 1;

    public Round(Integer round) {
        this.round = round;
    }

    public static Round from(String round) {
        if (isBlank(round)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ROUND);
        }
        if (isNotNumber(round)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ROUND_NUMBER);
        }

        return new Round(Integer.valueOf(round));
    }

    private static boolean isNotNumber(String round) {
        return !round.matches(NUMBER_REGEX) || Integer.valueOf(round) < MIN_NUMBER;
    }

    private static boolean isBlank(String round) {
        return Objects.isNull(round) || round.trim().isEmpty();
    }

    public int getRound() {
        return this.round;
    }
}
