package racingcar;

public enum MessageUtils {
    INPUT_CAR("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_TRY("시도할 횟수는 몇회인가요?"),
    OUTPUT_DASH("-"),
    OUTPUT_WINNER("최종 우승자 : "),

    VALIDATE_NAME("글자를 초과하여 입력하였습니다."),

    VALIDATE_CNT("숫자 이외의 값을 입력하였습니다.");

    private final String message;

     MessageUtils(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
