import raceCar.GameManager;
import raceCar.controller.GameController;
import raceCar.view.GameView;

public class Application {
	public static void main(String[] args) {
		GameManager gameManager = new GameManager();
		GameController gameController = new GameController(new GameView(), gameManager);
		gameController.run();
	}
}