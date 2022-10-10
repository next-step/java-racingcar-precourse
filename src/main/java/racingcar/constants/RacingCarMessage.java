package racingcar.constants;

public class RacingCarMessage {
	public static final String CAR_NAME_COMMA = ",";
	public static final String CAR_NAME_HYPHEN = "-";
	public static final String CAR_NAME_COLON = " : ";
	public static final String ERROR_PREFIX = "[ERROR]";
	
	public static final String MESSAGE_INPUT_CAR = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)기준으로 구분)";
	public static final String MESSAGE_INPUT_ATTEMPT = "시도할 횟수는 몇회인가요?";
	
	public static final String MESSAGE_RESULT = "실행결과";
	public static final String MESSAGE_WINNER = "최종 우승자"+CAR_NAME_COLON;
	
	public static final String MESSAGE_VALIDATION_INPUT_LENGTH = ERROR_PREFIX + "자동차 이름은 1자 이상 5자 이하입니다.";
	public static final String MESSAGE_VALIDATION_INPUT_NUM = ERROR_PREFIX + "1 이상의 자연수를 입력해주세요.";
}
