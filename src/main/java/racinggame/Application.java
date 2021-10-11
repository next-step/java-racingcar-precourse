package racinggame;

import racinggame.controller.RacinggameController;

public class Application {
	public static void main(String[] args) {
		RacinggameController racinggameController = new RacinggameController();
		racinggameController.startGame();
	}
}
