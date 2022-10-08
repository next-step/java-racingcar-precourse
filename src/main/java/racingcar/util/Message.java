package racingcar.util;

public enum Message {
    INPUT_CAR("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_REPEAT_COUNT("시도할 회수는 몇회인가요?"),
    RESULT("실행 결과"),
    SEPARATOR(" : "),
    DASH("-"),
    WINNER("최종 우승자 : %s"),
    ERROR_LENGTH_OF_CAR_NAME("[ERROR] 자동차 이름은 5자 이하로만 설정 가능합니다."),
    ERROR_MORE_THAN_TWO("[ERROR] 자동차 이름을 2개 이상 입력해주세요."),
    ERROR_CANNOT_INCLUDE_BLANK("[ERROR] 자동차 이름에 공백을 포함할 수 없습니다."),
    ERROR_DUPLICATE_OF_CAR_NAME("[ERROR] 자동차 이름이 중복됩니다."),
    ERROR_ONLY_NUMBERS("[ERROR] 반복 횟수는 숫자만 입력 가능합니다."),
    ERROR_MORE_THAN_ONE("[ERROR] 반복 횟수는 1 이상만 입력 가능합니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
