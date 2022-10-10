package racingcar.utils;

public enum Message {

    NUMBER_FORMAT_EXCEPTION("숫자형식으로 입력해주세요"),
    STRING_DUPLICATE_EXCEPTION("중복되지 않은 문자로 입력해주세요"),
    STRING_EMPTY_EXCEPTION("문자를 입력해주세요"),
    STRING_MAXLENGTH_EXCEPTION("제한된 문자 길이 안으로 입력해주세요. 제한 길이 : "),
    CAR_NUMBER_EXCEPTION("경주에 가능한 최소 개수를 입력해주세요. 최소 개수 : "),
    MIN_TRY_NUMBER_EXCEPTION("경주 진행 가능한 최소 숫자를 입력해주세요. 최소 숫자 : ");

    private String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}
