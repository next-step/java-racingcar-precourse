package racinggame.domain;

/**
 * 자동차 게임에서 사용되는 에러 메세지를 정의
 * @author Lee SeongHyeok <dltjdgur327@gmail.com>
 * @version 1.0
 * @since 1.0
 */
public enum GameErrorMessage {

    /** 자동차 이름은 1~5자 이내로 입력해주세요. */
    ERROR_RACING_CAR_NAME_LENGTH_LIMIT_MESSAGE("[ERROR] : 자동차 이름은 1~5자 이내로 입력해주세요."),

    /** 시도 횟수는 숫자만 입력 가능합니다. */
    ERROR_TRY_COUNT_ONLY_NUMBER("[ERROR] : 시도 횟수는 숫자만 입력 가능합니다."),

    /** 시도 횟수는 0보다 큰 숫자로 입력해주세요. */
    ERROR_TRY_COUNT_GREATER_THAN_ZERO("[ERROR] : 시도 횟수는 0보다 큰 숫자로 입력해주세요."),
    ;

    private String errorMessage;

    GameErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
