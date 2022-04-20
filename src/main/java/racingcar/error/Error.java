package racingcar.error;

public enum Error {
    MUST_MORE_THAN_2("둘 이상의 자동차 이름을 입력해주세요."),
    MUST_BE_NUMBER("숫자만 입력할 수 있습니다."),
    MUST_LESS_THAN_5("이름은 5자 이하만 가능합니다.");
    private String message;

    Error(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "[ERROR]" + message;
    }
}
