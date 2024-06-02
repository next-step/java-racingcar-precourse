package validator;

import static validator.ErrorMessages.*;

public class NumberValidator {

    /**
     * 이동 횟수를 검증한다
     * @param numberAsString
     * @throws IllegalArgumentException
     * numberAsString이 1이상의 정수가 아닐 때
     */
    public void test(String numberAsString) throws IllegalArgumentException {
        int number;
        try {
            number = Integer.parseInt(numberAsString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_INVALID);
        }
        if (number < 1) {
            throw new IllegalArgumentException(NUMBER_NOT_POSITIVE);
        }
    }
}
