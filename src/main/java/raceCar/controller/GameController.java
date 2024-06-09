package raceCar.controller;

import raceCar.GameManager;
import raceCar.GameValidator;
import raceCar.view.GameView;

public class GameController {
	GameView gameView;
	GameManager gameManager;

	public void run() {
		gameManager.initGame();
		String[] carNames = GameValidator.validateUserCarInput(gameView.requestCarInputRequest()).split(",");
		gameManager.addCar(carNames);
		int attempts = Integer.parseInt(GameValidator.validateNumber(gameView.requestAttemptsNum()));
		gameView.printPreResultMessage();
		for (int i = 0; i < attempts; i++) {
			gameManager.runRound();
			gameView.printResult(gameManager.announceResult());
		}
		gameView.printWinner(gameManager.announceWinner());
	}

	public GameController(GameView gameView, GameManager gameManager) {
		this.gameView = gameView;
		this.gameManager = gameManager;
	}
}
