package racinggame;

public class Application {
	private static GameController gameController = new GameController();
	private static Repeat repeat = Repeat.createRepeat();

	public static void main(String[] args) {
		// TODO 자동차 경주 게임 구현
		enterRacingCarNames();

		enterMoveCount();

		startRacingGame();

		printResult();
	}

	private static void enterRacingCarNames() {
		while (repeat.isTrue()) {
			String[] carNames = gameController.printEnterCarNames();
			repeat.set(gameController.createCars(carNames));
		}
	}

	private static void enterMoveCount() {
		repeat.init();
		while (repeat.isTrue()) {
			repeat.set(gameController.printEnterMoveCount());
		}
	}

	private static void startRacingGame() {
		gameController.startRacing();
	}

	private static void printResult() {
		gameController.printRacingGameWinners();
	}

}
