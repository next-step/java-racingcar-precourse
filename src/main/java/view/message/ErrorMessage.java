package view.message;

public enum ErrorMessage {
    CAR_NAME_LENGTH_EXCEPTION_MESSAGE("자동차 이름은 5자 이하만 가능합니다"),
    CAR_NAME_DUPLICATE_EXCEPTION_MESSAGE("자동차 이름이 중복되었습니다"),
    INVALID_TRIAL_NUMBER_EXCEPTION_MESSAGE("1 이상의 숫자만 입력해 주세요"),
    CAR_NAME_EMPTY_EXCEPTION_MESSAGE("공백 문자를 입력하였습니다")

    ;

    private final String message;
    private final String errorPrefixMessage = "[ERROR]";

    ErrorMessage(String message) {
        this.message = this.errorPrefixMessage + message;
    }

    @Override
    public String toString() {
        return message;
    }
}
