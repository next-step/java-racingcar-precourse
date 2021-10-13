package racinggame.constants;

public enum Messages {
    CAR_NAME_BLANK_INVALID("자동차 이름은 공백을 허용하지 않음."),
    CAR_NAME_DIGIT_INVALID("자동차 이름은 5글자 이하로 작성요함."),
    CAR_NAME_USER_INPUT("경주할 자동차이름을입력하세요.(이름은쉼표(,)기준으로구분)"),
    CAR_PARTIPCIPANT_INVALID("자동차는 2대 이상 입력요함."),
    CAR_MOVE_TRY_USER_INPUT("시도할 횟수는 몇회인가요?"),
    MOVE_CONDITION_NUM_INVALID("0-9 사이의 수만 가능함."),
    MOVE_TRY_NUM_INVALID("시도횟수는 0이상의 숫자만 가능함."),
    GAME_RESULT("실행 결과"),
    CAR_NAME_COLON("%s : "),
    GAME_WINNERS("최종 우승자는 %s 입니다."),
    ERROR_MESSAGE("[ERROR]");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
