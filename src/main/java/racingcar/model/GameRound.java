package racingcar.model;

import racingcar.util.Message;

public class GameRound {
    public static final int MINIMUM_GAME_ROUND = 1;

    private final int round;

    public GameRound(String inputRound) {
        validNumeric(inputRound);
        int intRound = convertInt(inputRound);
        validZero(intRound);
        this.round = intRound;
    }

    private int convertInt(String inputRound) {
        return Integer.parseInt(inputRound);
    }

    private void validNumeric(String inputRound) {
        if (isNoneNumeric(inputRound)) {
            throw new IllegalArgumentException(Message.ERROR_ROUND_IS_NONE_NUMERIC.getMessage());
        }
    }

    private void validZero(int intRound) {
        if (isZero(intRound)) {
            throw new IllegalArgumentException(Message.ERROR_ROUND_IS_ZERO.getMessage());
        }
    }

    private boolean isNoneNumeric(String inputRound) {
        return !inputRound.chars().allMatch(Character::isDigit);
    }

    private boolean isZero(int intRound) {
        return intRound < MINIMUM_GAME_ROUND;
    }

    public int getRound() {
        return round;
    }
}
