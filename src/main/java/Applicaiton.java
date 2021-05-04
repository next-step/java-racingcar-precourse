import java.io.IOException;

import domain.RacingGame;
import view.InputView;

public class Applicaiton {

	public static void main(String[] args) throws IOException {
		InputView.askCarNames();
		InputView.askRoundCount();

		RacingGame racingGame = new RacingGame(InputView.getCarNames(), InputView.getRoundCount());
		racingGame.run();
	}
}
