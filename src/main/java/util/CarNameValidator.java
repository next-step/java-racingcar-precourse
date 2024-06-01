package util;

public class CarNameValidator implements InputValidator {

    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final String CAR_NAME_ERROR_MESSAGE = "자동차 이름의 길이가 " + CAR_NAME_MAX_LENGTH + "를 초과하였습니다.";

    @Override
    public void checkInputValue(String input) {
        if (input.length() > CAR_NAME_MAX_LENGTH) {
            raiseIllegalArgumentException(CAR_NAME_ERROR_MESSAGE);
        }
    }
}
