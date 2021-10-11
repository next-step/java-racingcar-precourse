package racinggame;

public enum RaceErrorCode {
    INVALID_CAR_NAME_LENGTH("[ERROR] : 잘못된 길이의 자동차 이름 입력입니다. 각 자동차의 이름을 5자 이상으로 입력하세요.")
    ;

    private final String message;

    RaceErrorCode(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
