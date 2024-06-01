package util;

public class AttemptNumberValidator implements InputValidator {

    private static final String ATTEMPT_NUMBER_ERROR_MESSAGE = "0 이상의 정수가 아닌 값을 입력받았습니다";

    @Override
    public void checkInputValue(String input) {
        int attemptNumber = 0;

        try {
            attemptNumber = Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            raiseIllegalArgumentException(ATTEMPT_NUMBER_ERROR_MESSAGE);
            return;
        }
        if (attemptNumber < 0) {
            raiseIllegalArgumentException(ATTEMPT_NUMBER_ERROR_MESSAGE);
        }
    }
}
