package message;

public class Message {
    //Input Message
    public static final String GET_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String GET_TRY_NUMBER = "시도할 회수는 몇회인가요?";

    //Output Message
    public static final String EXECUTION_RESULT = "실행 결과";
    public static final String IS_WINNER = "가 최종 우승했습니다.";

    //Error Message
    public static final String ERROR_CAR_NAME_RANGE = "자동차의 이름은 1글자 이상 5글자 이하이어야 합니다.";
    public static final String ERROR_CAR_NAME_DUPLICATE = "자동차 이름 중복 됩니다.";
    public static final String ERROR_IS_NOT_NUMBER = "시도 횟수는 정수로 입력하세야 합니다.";
    public static final String ERROR_TRY_COUNT = "시도 횟수는 1 이상 이어야 합니다.";

}
