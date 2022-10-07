package racingcar.model.race.wrap_variable;

import racingcar.constant.Message;

public class NumberOfAttemptMove {
    private final int numberOfAttemptMove;

    public NumberOfAttemptMove(String strNumber) {
        if (!isNumeric(strNumber)) {
            throw new IllegalArgumentException(Message.ERROR_MESSAGE + "시도 회수는 0을 초과하는 숫자만 입력할 수 있습니다");
        }
        this.numberOfAttemptMove = Integer.parseInt(strNumber);
    }

    public int getNumberOfAttemptMove() {
        return numberOfAttemptMove;
    }

    private static boolean isNumeric(String s) {
        try {
            double num = Double.parseDouble(s);
            return !(num <= 0);
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
