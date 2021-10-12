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
	}

	private void inputGameInfo() {
		String nameStr = view.inputCarNameStr();
		cars = Cars.createByNames(nameStr);
		gameCount = view.inputGameCount();
	}

	private void playGame() {
		view.printPlayResultMessage();
		for (int i = 0; i < gameCount.getCount(); i++) {
			view.printPlayResult(cars.play());
		}
		view.printWinners(cars.getWinners());
	}
}
