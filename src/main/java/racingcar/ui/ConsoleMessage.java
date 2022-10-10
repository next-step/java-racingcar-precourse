package racingcar.ui;

public enum ConsoleMessage {

    CAR_NAME_ERROR("자동차 이름은 공백을 제외한 1자 이상, 5자 이하로 입력해야 합니다."),
    CARS_INVALID_NAMES_ERROR("유효한 이름으로 2개 이상 입력해야 합니다."),
    CARS_DUPLICATED_NAMES_ERROR("동일한 이름은 입력할 수 없습니다."),
    WINNERS_RESULT("최종 우승자 : %s 입니다."),
    ATTEMPT_COUNT_ERROR("시도 횟수는 1 이상으로 입력해야 합니다."),
    CAR_NAMES_INPUT("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ATTEMPT_COUNT_INPUT("시도할 회수는 몇회인가요?"),
    RESULT_HEADER("실행 결과");

    private final String message;

    ConsoleMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
