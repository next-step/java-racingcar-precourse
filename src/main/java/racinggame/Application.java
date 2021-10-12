package racinggame;

import racinggame.controller.RacingGameController;
import racinggame.domain.Cars;
import racinggame.domain.RaceCount;
import racinggame.view.InputView;

public class Application {
	public static void main(String[] args) {
		Cars cars = InputView.getCars();
		RaceCount raceCount = InputView.getRaceCount();

		RacingGameController.run(cars, raceCount);
	}
}
