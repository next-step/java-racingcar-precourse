package racingcar;

public enum Constans {

    ERROR_PREFIX("[ERROR] "),
    ERROR_MAXIMUM_LANGTH("5자 미만의 이름으로 설정해야만 합니다."),
    ERROR_NUMBER_FORMAT("시도 횟수는 숫자여야 한다."),
    ERROR_LIST_INPUT_FORMAT("',' 로 구분된 2개 이상의 레이싱카 목록을 입력해 주세요."),
    MESSAGE_GAME_INPUT_CAR_LIST("경주 할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    MESSAGE_GAME_INPUT_TRY_NUMBER("시도할 회수는 몇회인가요?"),
    MESSGAE_GAME_WINNER_PREFIX("최종 우승자 : "),
    MESSAGE_GAME_RESULT("\n실행 결과"),
    DELEMITER(","),
    EMPTYSTR(" "), SIMBOL_GO_STATUS("-");

    private String message;

    Constans(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
