package racingcar;

/**
 * @author SeongRok.Oh
 * @since 2022/10/09
 */
public enum PrintMessage {
    INPUT_RACING_CAR_NAME("경주 할 자동차 이름 (이름은 쉼표(,) 기준으로 구분)"),
    INPUT_RACING_CAR_TRY_COUNT("시도할 회수"),
    TRY_COUNT_NUMBER_FORMAT_ERROR("[ERROR] 시도 횟수는 숫자여야 한다."),
    NAME_OUT_OF_LENGTH_ERROR("[ERROR] 이름은 5글자를 넘을 수 없습니다."),
    NAME_EMPTY_ERROR("[ERROR] 이름은 공백일 수 없습니다."),
    WINNER("최종 우승자 : %s"),
    ;
    private final String message;

    PrintMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
