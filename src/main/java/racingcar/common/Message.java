package racingcar.common;

public class Message {
	public static final String CAR_NAME_INPUT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	public static final String TRY_COUNT_INPUT = "시도할 횟수는 몇회인가요?";
	public static final String ROUND_RESULT = "실행결과";
	public static final String FINAL_WINNER_PREFIX = "최종 우승자: ";

	public static final String ERROR_PREFIX = "[ERROR] ";
	public static final String ERROR_INPUT_EMPTY = ERROR_PREFIX + "자동차 이름을 입력하세요.";
	public static final String ERROR_MIN_CAR_COUNT = ERROR_PREFIX + "최소 2대 이상의 자동차 이름을 입력하세요.";
	public static final String ERROR_CAR_NOT_UNIQUE = ERROR_PREFIX + "중복되는 자동차 이름이 존재합니다.";
	public static final String ERROR_CAR_NAME_LENGTH = ERROR_PREFIX + "자동차 이름의 길이는" + GameConfig.MAX_CAR_NAME_LENGTH + " 이하여야 합니다.";
	public static final String ERROR_CAR_NAME_EMPTY = ERROR_PREFIX + "자동차 이름은 공백일 수 없습니다.";
	public static final String ERROR_TRY_COUNT_NOT_NUMBER = ERROR_PREFIX + "1 이상의 양의 정수를 입력하세요.";
}
