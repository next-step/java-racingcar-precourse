package racingcar.domain;

public enum ErrorMessage {
    
    OUT_OF_RANGE_NAME_ERROR("자동차 이름은 %d자 이상 %d자 이하만 허용됩니다."),
    OUT_OF_RANGE_NUMBER_ERROR("숫자는 %d 이상 %d 이하만 허용됩니다."),
    NEGATIVE_NUMBER_ERROR("입력값은 %d 이상만 허용됩니다. "),
    NOT_DIGIT_ERROR("숫자만 허용됩니다."),
    START_ROUND_WHEN_GAME_OVER_ERROR("이미 모든 라운드를 진행하였습니다.");

    public static final String LEVEL = "[ERROR]";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    } 

    public String getMessage() {
        return addPrefix(message);
    }

    public String getMessage(Object... values) {
        return addPrefix(String.format(message, values));
    }

    private String addPrefix(String message) {
        return String.format("%s %s", LEVEL, message);
    }
}
