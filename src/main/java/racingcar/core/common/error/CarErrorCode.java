package racingcar.core.common.error;

public enum CarErrorCode implements ErrorCode {

    CAR_NAME_OVER_MAX_LENGTH("가능한 자동차 이름 길이를 초과하였습니다."),
    UNABLE_TO_FIND_MAX_DISTANCE("최대 거리를 구할 수 없습니다."),
    NOT_ALLOW_PICK_NUMBER("1~9 사이 값을 입력해주세요."),
    EXIST_DUPLICATE_CAR_NAME("중복된 이름이 존재합니다.");

    private final String errorMessage;

    CarErrorCode(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return ERROR_PREFIX + errorMessage;
    }
}
