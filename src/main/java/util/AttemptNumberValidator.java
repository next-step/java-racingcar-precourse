package util;

public class AttemptNumberValidator implements InputValidator {

    private static final int ATTEMPT_NUMBER_MINIMUM = 0;
    private static final String ATTEMPT_NUMBER_ERROR_MESSAGE = "0 이상의 정수가 아닌 값을 입력받았습니다";

    @Override
    public void checkInputValue(Object input) {
        int attemptNumber = ATTEMPT_NUMBER_MINIMUM;

        // 숫자가 아닌 값이면 예외 발생
        try {
            attemptNumber = Integer.parseInt((String) input);
        } catch (NumberFormatException exception) {
            raiseIllegalArgumentException(ATTEMPT_NUMBER_ERROR_MESSAGE);
            return;
        }
        // 0 이상의 정수가 아닌 숫자면 예외 발생
        if (attemptNumber < ATTEMPT_NUMBER_MINIMUM) {
            raiseIllegalArgumentException(ATTEMPT_NUMBER_ERROR_MESSAGE);
        }
    }
}
