package racingcar.constant;

public final class ErrorMessage {
    private static final String CREATION_ERROR_MESSAGE = "[ERROR] common message class";
    public static final String NOT_VALID_CAR_NAME_MESSAGE = "[ERROR] 이름은 5글자를 초과할 수 없습니다";
    public static final String NOT_CREATION_CAR_NAME_MESSAGE = "[ERROR] 이름에 대한 값이 없습니다.";
    public static final String NOT_VAILD_NUMBER_MESSAGE = "[ERROR] 유효하지 않은 숫자 값입니다.";
    public static final String NOT_CREATION_CAR_MESSAGE = "[ERROR] 등록된 자동차 정보가 없습니다.";


    private ErrorMessage() {
        throw new IllegalStateException(CREATION_ERROR_MESSAGE);
    }

}
