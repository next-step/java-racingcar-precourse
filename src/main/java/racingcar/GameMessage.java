package racingcar;

public class GameMessage {

	public static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	public static final String ERROR_CARS_MESSAGE = "올바른 자동차 이름이 입력되지 않았습니다. 다시 입력하세요.";
	public static final String ASK_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
	public static final String ERROR_NUMBER_MESSAGE = "입력한 값이 숫자가 아닙니다. 다시 입력하세요.";
	public static final String RESULT_MESSAGE = "\n실행결과";
	public static final String WINNER_MESSAGE = "%s가 최종 우승했습니다.";
	public static final String NO_WINNER = "우승자가 없습니다.";

	public static String getWinnerMessage(String winners) {
		return String.format(WINNER_MESSAGE, winners);
	}
}