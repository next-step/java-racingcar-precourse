package racingcar.model;

import racingcar.constant.Constant;
import racingcar.constant.ErrorMessage;
import racingcar.exception.CustomIllegalArgumentException;
import racingcar.exception.CustomNumberFormatException;

public class Repeat {

    private int repeatNumber;

    public Repeat(String repeatNumber) {
        this.repeatNumber = isValidate(repeatNumber);
    }

    public int isValidate(String repeatNumber) {
        int convertedNumber = isNumeric(repeatNumber);
        isPositive(convertedNumber);
        return convertedNumber;
    }

    private int isNumeric(String repeatNumber) {
        int convertedRepeatNumber;
        try {
            convertedRepeatNumber = Integer.parseInt(repeatNumber);
        } catch (NumberFormatException formatException) {
            throw new CustomNumberFormatException(ErrorMessage.REPEAT_TIME_NON_NUMERIC.getValue());
        }
        return convertedRepeatNumber;
    }

    private void isPositive(int repeatNumber) {
        if (repeatNumber <= 0) {
            throw new CustomIllegalArgumentException(ErrorMessage.REPEAT_TIME_NON_POSITIVE.getValue());
        }
    }

    public boolean isEnd() {
        return repeatNumber == Constant.REPEAT_END;
    }

    public void reduce() {
        this.repeatNumber--;
    }
}
