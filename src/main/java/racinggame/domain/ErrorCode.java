package racinggame.domain;

public enum ErrorCode {
    BLANK_NAME("[ERROR] 자동차 이름은 필수 입니다. 입력해 주세요."),
    NAME_LENGTH_1TO5("[ERROR] 자동차 이름은 1~5자로 입력해 주세요."),
    DUPLICATION_NAME("[ERROR] 레이싱 게임 참가 자동차의 이름은 중복될 수 없습니다."),
    NEED_MORE_USERS("[ERROR] 레이싱 게임 참가 자동차는 1대이상 이어야 합니다."),
    ROUND_COUNT_ZERO("[ERROR] 시도할 횟수는 0보다 커야 합니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    String getMessage() {
        return message;
    }
}
