package racingcar.domain;

import java.util.regex.Pattern;
import racingcar.exception.ErrorMessage;
import racingcar.exception.RacinggameException;

public class Round {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[1-9]*?");

    private final int round;

    private Round(int round) {
        this.round = round;
    }

    public static Round from(String inputRound) {
        validateInputRound(inputRound);

        return new Round(Integer.parseInt(inputRound));
    }

    private static void validateInputRound(String inputRound) {
        if (!NUMBER_PATTERN.matcher(inputRound).matches()) {
            throw new RacinggameException(ErrorMessage.INVALID_INPUT_ROUND.getValue());
        }
    }

    public int getRound() {
        return this.round;
    }
}
