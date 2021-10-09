package racinggame.view;

import static racinggame.view.OutputView.Message.*;

import racinggame.model.Car;
import racinggame.model.Round;
import racinggame.model.Winner;
import racinggame.model.Winners;

public class OutputView {

	private static final int POSITION_START_INDEX = 1;
	private static final int LAST_STRING_DELETE_INDEX = 1;

	public void printInputName() {
		System.out.println(INPUT_NAME_MESSAGE);
	}

	public void printUserInputError(String message) {
		System.out.printf(USER_INPUT_ERROR_MESSAGE_FORMAT, message);
	}

	public void printInputCount() {
		System.out.println(GAME_COUNT_INPUT_MESSAGE);
	}

	public void printEmptyLine() {
		System.out.println();
	}

	public void printWinners(Winners winners) {
		StringBuilder winnerName = new StringBuilder();
		for (Winner winner : winners.getWinners()) {
			winnerName.append(winner.getName()).append(DELIMITER);
		}

		winnerName.deleteCharAt(winnerName.length() - LAST_STRING_DELETE_INDEX);
		System.out.printf(WINNER_MESSAGE_FORMAT, winnerName);
	}

	public void printRoundResult(Round round) {
		for (Car car : round.getCars()) {
			System.out.printf(USER_RESULT_FORMAT, car.getName(), convertPositionString(car.getPosition()));
		}
	}

	private String convertPositionString(int position) {
		StringBuilder sb = new StringBuilder();
		for (int index = POSITION_START_INDEX; index <= position; index++) {
			sb.append(POSITION_STRING);
		}
		return sb.toString();
	}

	public void printExecuteMessage() {
		System.out.println(EXECUTE_RESULT_MESSAGE);
	}

	static class Message {
		static final String INPUT_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분";
		static final String USER_INPUT_ERROR_MESSAGE_FORMAT = "[ERROR] %s %n";
		static final String GAME_COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
		static final String DELIMITER = ",";
		static final String WINNER_MESSAGE_FORMAT = "최종 우승자는 %s 입니다.";
		static final String USER_RESULT_FORMAT = "%s : %s%n";
		static final String POSITION_STRING = "-";
		static final String EXECUTE_RESULT_MESSAGE = "실행 결과";
	}
}
