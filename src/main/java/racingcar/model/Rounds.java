package racingcar.model;

import org.junit.platform.commons.util.StringUtils;
import racingcar.message.ExceptionMessage;
import racingcar.exception.InvalidRoundNumberException;
import racingcar.exception.NotContatinNumberException;
import racingcar.utils.PatternUtils;

public class Rounds {
    private static final int MAX_NUMBER = 1000;
    private static final int MIN_NUMBER = 1;

    private int number;

    public Rounds(String roundNumber) throws NotContatinNumberException, InvalidRoundNumberException {
        checkContainIfOnlyDigt(roundNumber);
        checkContainValidRoundNumber(roundNumber);

        this.number = Integer.parseInt(roundNumber);
    }

    public int getNumber() {
        return this.number;
    }

    private void checkContainIfOnlyDigt(String roundNumber) {
        if ( StringUtils.isBlank(roundNumber) || !PatternUtils.containOnlyDigit(roundNumber) ) {
            throw new NotContatinNumberException(ExceptionMessage.NOT_CONTAIN_ONLY_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    private void checkContainValidRoundNumber(String roundNumber) {
        if ( isExceedMaxRoundNumber(roundNumber) ) {
            throw new InvalidRoundNumberException(ExceptionMessage.MAX_ROUND_NUMBER_EXCEPTION_MESSAGE);
        }
        if ( isUnderMinRoundNumber(roundNumber) ) {
            throw new InvalidRoundNumberException(ExceptionMessage.MIN_ROUND_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    private boolean isExceedMaxRoundNumber(String roundNumber) {
        int curRoundNumber = 0;
        try {
            curRoundNumber = Integer.parseInt(roundNumber);
        } catch (NumberFormatException e) {
            throw new InvalidRoundNumberException(ExceptionMessage.MAX_ROUND_NUMBER_EXCEPTION_MESSAGE);
        }

        return curRoundNumber > MAX_NUMBER ? true : false;
    }

    private boolean isUnderMinRoundNumber(String roundNumber) {
        int curRoundNumber = 0;
        try {
            curRoundNumber = Integer.parseInt(roundNumber);
        } catch (NumberFormatException e) {
            throw new InvalidRoundNumberException(ExceptionMessage.MIN_ROUND_NUMBER_EXCEPTION_MESSAGE);
        }

        return curRoundNumber < MIN_NUMBER ? true : false;
    }
}
