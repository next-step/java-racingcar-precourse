import service.IRacingGame;
import service.impl.RacingGame;

public class Application {
	public static void main(String[] args) {
		final IRacingGame racingGame = new RacingGame();
		racingGame.play();
	}
}
