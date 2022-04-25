package racingcar.domain;

import static racingcar.BaseConstants.ERROR_MSG_EMPTY_VALUE;
import static racingcar.BaseConstants.ERROR_MSG_SHOULD_BE_ENTERED_BIGGER_THAN_0;
import static racingcar.BaseConstants.ERROR_MSG_SHOULD_BE_ENTERED_ONLY_NUMBER;

import camp.nextstep.edu.missionutils.Console;

/**
 * @author jinyoung
 * @since 2022/04/23
 */
public class RacingMovingRound {

    private final Integer movingNumber;

    RacingMovingRound(String movingNumber) {
        if ("".equals(movingNumber) || movingNumber == null) {
            throw new IllegalArgumentException(ERROR_MSG_EMPTY_VALUE);
        }

        try {
            this.movingNumber = Integer.valueOf(movingNumber);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException(ERROR_MSG_SHOULD_BE_ENTERED_ONLY_NUMBER);
        }

        if (this.movingNumber <= 0) {
            throw new IllegalArgumentException(ERROR_MSG_SHOULD_BE_ENTERED_BIGGER_THAN_0);
        }
    }

    public Integer movingNumber() {
        return this.movingNumber;
    }

    public static RacingMovingRound getRacingMovingRound() {
        final String movingNumber = Console.readLine();
        try {
            return new RacingMovingRound(movingNumber);
        } catch (IllegalArgumentException iae) {
            System.out.println("[ERROR] " + iae.getMessage());
            return getRacingMovingRound();
        }
    }
}
