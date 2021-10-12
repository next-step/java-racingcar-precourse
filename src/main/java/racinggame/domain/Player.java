package racinggame.domain;

import nextstep.utils.Console;
import racinggame.exception.RacingGameErrorCode;
import racinggame.exception.RacingGameException;

public class Player {
    public AttemptNumber inputAttemptNumber() {
        String input = Console.readLine();
        try {
            return new AttemptNumber(Integer.parseInt(input));
        } catch (Exception e) {
            throw new RacingGameException(RacingGameErrorCode.INVALID_NUMBER);
        }
    }

    public String inputNames() {
        return Console.readLine();
    }
}
