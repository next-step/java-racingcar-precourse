package racinggame;

public class GameController {
	private final GameView view;
	private GameCount gameCount;
	private Cars cars;

	public GameController() {
		view = new GameView();
	}

	public void start() {
		inputGameInfo();
		playGame();
	}

	private void inputGameInfo() {
		cars = view.inputCarName();
		gameCount = view.inputGameCount();
	}

	private void playGame() {
		view.printPlayResultSubject();
		for (int i = 0; i < gameCount.getCount(); i++) {
			view.printPlayResult(cars.play());
		}
		view.printWinners(cars.getWinners());
	}
}
