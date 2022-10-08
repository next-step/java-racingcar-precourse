package racingcar.domain;

import racingcar.utils.CommonUtil;

import static racingcar.constant.Constant.*;

public class CarNumber {
    private int number;

    public CarNumber(String number) {
        validationNumber(number);
        this.number = getParseInt(number);
    }

    public int getNumber() {
        return number;
    }

    public static void validationNumber(String number) {
        CommonUtil.isNullOrEmptyCheck(number);
        int parsingNumber = getParseInt(number);
        if (parsingNumber < MIN_NUMBER || parsingNumber > MAX_NUMBER) {
            throw new IllegalArgumentException(INPUT_NUMBER_RANGE);
        }
    }

    private static int getParseInt(String number) {
        return Integer.parseInt(number);
    }
}
