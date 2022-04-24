package racingcar.domain;

import static racingcar.domain.ErrorMessage.GAME_ROUND_INPUT_ERROR;

public class GameRound {

    private static final int MIN_VALUE = 1;

    private final int value;

    public GameRound(String value) {
        this.value = parseValue(value);
    }

    private int parseValue(String value) {
        try {
            int round = Integer.parseInt(value);
            validateValue(round);
            return round;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(GAME_ROUND_INPUT_ERROR);
        }
    }

    private void validateValue(int value) {
        if (value < MIN_VALUE) {
            throw new IllegalArgumentException(GAME_ROUND_INPUT_ERROR);
        }
    }

    public int getValue() {
        return value;
    }
}
