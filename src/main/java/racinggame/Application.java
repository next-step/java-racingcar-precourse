package racinggame;

import racinggame.controller.RacingGame;
import racinggame.view.User;

public class Application {

	private static User user = new User();
	private static RacingGame racingGame = null;

	public static void main(String[] args) {
		do {
			racingGame = new RacingGame(user);
		} while ((!racingGame.isReady()));

		racingGame.play();
	}
}
