package racinggame;

import java.util.List;

import nextstep.utils.Console;

public class GameView {
	private final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private final String INPUT_GAME_COUNT_MESSAGE = "시도할 횟수는 몇회인가요?";
	private final String PLAY_RESULT_SUBJECT = "실행 결과";

	public Cars inputCarName() {
		try {
			System.out.println(INPUT_CAR_NAME_MESSAGE);
			return Cars.createByNames(Console.readLine());
		} catch (IllegalArgumentException e) {
			printErrorMessage(e.getMessage());
			return inputCarName();
		}
	}

	public GameCount inputGameCount() {
		try {
			System.out.println(INPUT_GAME_COUNT_MESSAGE);
			return new GameCount(Integer.parseInt(Console.readLine()));
		} catch (NumberFormatException e) {
			printErrorMessage("[ERROR] 숫자를 입력해주세요.");
			return inputGameCount();
		} catch (IllegalArgumentException e) {
			printErrorMessage(e.getMessage());
			return inputGameCount();
		}
	}

	public void printPlayResultSubject() {
		System.out.println(PLAY_RESULT_SUBJECT);
	}

	public void printPlayResult(PlayResult play) {
		for (int i = 0; i < play.size(); i++) {
			System.out.println(play.get(i));
		}
		System.out.println("");
	}

	public void printWinners(List<Car> winners) {
		String[] winnerArray = new String[winners.size()];
		for (int i = 0; i < winners.size(); i++) {
			winnerArray[i] = winners.get(i).getName();
		}
		String winnerNames = String.join(",", winnerArray);
		System.out.println("최종 우승자는 " + winnerNames + " 입니다.");
	}

	public void printErrorMessage(String message) {
		System.out.println(message);
	}
}
