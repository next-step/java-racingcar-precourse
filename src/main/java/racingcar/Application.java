package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Game;
import racingcar.service.GameService;

public class Application {

	public static void main(String[] args) {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String input = Console.readLine();

		Game game = new Game(input);

		System.out.println("시도할 회수는 몇 회인가요");
		String turnCountStr = Console.readLine();
		int turnCount = Integer.parseInt(turnCountStr);

		System.out.println("실행 결과");
		GameService gameService = new GameService();
		gameService.doGame(game, turnCount);

		gameService.printWinner(game);
	}

}
