package racingcar.constants;

public class Message {

    public static final String ERROR_MESSAGE_PATTERN = "[ERROR] %s";
    public static final String INVALID_CAR_NAME_PATTERN = "자동차 이름은 최대 %s 글자까지 가능합니다.";
    public static final String INVALID_TRY_COUNT_MESSAGE = "시도 횟수는 숫자만 가능합니다.";

    public static final String INIT_CARS_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INIT_TRY_COUNT_MESSAGE = "시도할 횟수는 몇회인가요?";
    public static final String TRY_TO_MOVE_HEAD_MESSAGE = "실행 결과";
    public static final String TRY_TO_MOVE_RESULT_PATTERN = "%s : %s";
    public static final String WINNERS_RESULT_PATTERN = "최종 우승자 : %s";

    private Message() {
    }
}
