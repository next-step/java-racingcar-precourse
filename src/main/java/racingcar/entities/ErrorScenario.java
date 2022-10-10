package racingcar.entities;

public enum ErrorScenario {
    WRONG_NAME_INPUT_BASIC("[ERROR]입력값이 잘못 되었습니다. 이름 구분을 쉼표(,)로 입력해주세요"),
    NULL_NAME_INPUT("[ERROR]입력값이 없습니다. 다시 입력해주세요"),
    OVER_MAX_NAME_LENGTH("[ERROR]입력받은 이름 중 길이가 5가 넘는 이름이 있습니다. 다른 이름을 입력해주세요."),
    ASK_RACING_CARS_NAME_AGAIN("[ERROR]이름을 다시 입력해주세요"),
    WRONG_ISGAMEPROCEEDWITHONECAR_INPUT("[ERROR]1,2중 하나로 입력해주세요."),
    WRONG_GAMETIMEINPUT("[ERROR]입력값이 잘못 되었습니다. 숫자만 입력해주세요"),
    GAMETIMEINPUT_IS_ZERO("[ERROR]0보다 큰 수를 입력해주세요");
    private final String errorPhrases;


    ErrorScenario(String errorPhrases) {
        this.errorPhrases = errorPhrases;
    }

    public String getErrorPhrases() {
        return errorPhrases;
    }
}
