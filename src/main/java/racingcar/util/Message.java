package racingcar.util;

public enum Message {
    INPUT_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_ROUND_COUNT("시도할 횟수는 몇회인가요?"),
    ERROR_VALID_CAR_NAME("자동차 이름은 1자 이상 5자 이하로 입력하세요."),
    ERROR_CAR_NAME_IS_BLANK("자동차 이름을 입력해주세요.(공백 불가)"),
    ERROR_CAR_NAME_DUPLICATE_SEPARATOR("구분자(,)는 중복될 수 없습니다."),
    ERROR_CAR_NAME_DUPLICATE("자동차의 이름은 중복될 수 없습니다."),
    ERROR_MINIMUM_PARTICIPATE_CAR("최소 참가 인원은 2명입니다."),
    ERROR_ROUND_IS_NONE_NUMERIC("시도 횟수는 숫자여야 합니다."),
    ERROR_ROUND_IS_ZERO("시도 횟수는 0이상으로 입력해주세요."),
    VICTORY_PREFIX("최종 우승자 : "),
    ERROR_PREFIX("[ERROR] : ");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
