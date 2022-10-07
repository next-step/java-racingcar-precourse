package racingcar.service;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Game;

class GameServiceTest {


	@Test
	@DisplayName("턴 하나 테스트")
	public void doTurn() throws Exception {
		Game game = new Game("Kim,su");
		GameService gameService = new GameService();

		for (int i = 0; i < 100; i++) {
			System.out.println("턴 하나 시작");
			gameService.doTurn(game);
			System.out.print(game.toString());
		}
	}

	@Test
	@DisplayName("게임테스트")
	public void test2() throws Exception {
		Game game = new Game("Kim,su");
		GameService gameService = new GameService();

		gameService.doGame(game, 5);
		System.out.print(game.toString());
	}

	@Test
	@DisplayName("우승자 포지션 구하기")
	public void getMaxPositionTest() throws Exception {
		Game game = new Game("Kim,su,g,e");
		GameService gameService = new GameService();

		for (int i = 0; i < 10; i++) {
			gameService.doTurn(game);
		}

		System.out.println(game.toString());
		int maxPosition = 0;

		for (Car car : game.getCarList()) {
			maxPosition = gameService.getMaxPosition(maxPosition, car);
		}

		System.out.println(maxPosition);
	}

	@Test
	@DisplayName("우승자_스트링_구하기")
	public void 우승자_스트링_구하기() throws Exception {
		Game game = new Game("Kim,su,g,e");
		GameService gameService = new GameService();

		for (int i = 0; i < 10; i++) {
			gameService.doTurn(game);
		}

		System.out.println(game.toString());

		int maxPosition = 0;

		for (Car car : game.getCarList()) {
			maxPosition = gameService.getMaxPosition(maxPosition, car);
		}

		String winnerStr = "";

		for (Car car : game.getCarList()) {
			winnerStr += gameService.getWinnerStr(winnerStr, maxPosition, car);
		}

		System.out.println(winnerStr);
	}


}