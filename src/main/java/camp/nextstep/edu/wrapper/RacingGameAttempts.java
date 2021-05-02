package camp.nextstep.edu.wrapper;

import camp.nextstep.edu.constant.Message;

public class RacingGameAttempts {

    private int attempts;

    public RacingGameAttempts(String str) {
        try {
            this.attempts = validatedNumber(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public int getAttempts() {
        return attempts;
    }

    private int validatedNumber(String str) {
        int number = Integer.parseInt(str);
        if (number <= 0) {
            throw new IllegalArgumentException(Message.INVALID_NUMBER_OF_ATTEMPTS);
        }
        return number;
    }
}
