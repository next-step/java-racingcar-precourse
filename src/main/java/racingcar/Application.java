package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Game;
import racingcar.service.GameService;

public class Application {

	public static void main(String[] args) {
		Game game = getGame();

		int turnCount = getTurnCount();

		System.out.println("실행 결과");
		GameService gameService = new GameService();
		gameService.doGame(game, turnCount);

		gameService.printWinner(game);
	}

	public static Game getGame() {
		try {
			String input = getCarName();
			Game game = new Game(input);
			return game;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getGame();
		}
	}

	public static String getCarName() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String input = Console.readLine();

		return input;
	}

	public static int getTurnCount() {
		System.out.println("시도할 회수는 몇 회인가요");
		String turnCountStr = Console.readLine();
		try {
			int turnCount = Integer.parseInt(turnCountStr);
			return turnCount;
		} catch (NumberFormatException e) {
			System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.");
			return getTurnCount();
		}
	}


}
