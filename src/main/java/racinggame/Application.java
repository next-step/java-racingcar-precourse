package racinggame;

import racinggame.domain.Cars;
import racinggame.domain.Cycle;
import racinggame.domain.RacingGame;
import racinggame.view.CarInput;
import racinggame.view.CycleInput;

public class Application {
	public static void main(String[] args) {
		RacingGame racingGame = new RacingGame(Cars.init(CarInput.getInput()), Cycle.init(CycleInput.getInput()));
		racingGame.start();
	}
}
