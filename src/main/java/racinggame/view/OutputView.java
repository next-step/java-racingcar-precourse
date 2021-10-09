package racinggame.view;

import racinggame.model.Car;
import racinggame.model.Round;
import racinggame.model.Winner;
import racinggame.model.Winners;

public class OutputView {

	public void printInputName() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
	}

	public void printUserInputError(String message) {
		System.out.println("[ERROR] " + message);
	}

	public void printInputCount() {
		System.out.println("시도할 회수는 몇회인가요?");
	}

	public void printEmptyLine() {
		System.out.println();
	}

	public void printWinners(Winners winners) {
		StringBuilder winnerName = new StringBuilder();
		for (Winner winner : winners.getWinners()) {
			winnerName.append(winner.getName()).append(",");
		}

		winnerName.deleteCharAt(winnerName.length() - 1);
		System.out.printf("최종 우승자는 %s 입니다.", winnerName);
	}

	public void printRoundResult(Round round) {
		for (Car car : round.getCars()) {
			System.out.println(car.getName() + " : " + convertPositionString(car.getPosition()));
		}
	}

	private String convertPositionString(int position) {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= position; i++) {
			sb.append("-");
		}
		return sb.toString();
	}

	public void printExecuteMessage() {
		System.out.println("실행 결과");
	}
}
