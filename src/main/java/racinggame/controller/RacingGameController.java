package racinggame.controller;

import racinggame.domain.Cars;
import racinggame.domain.boxing.Round;
import racinggame.view.OutputView;
import racinggame.view.PlayerInputView;

public class RacingGameController {

	private OutputView outputView = new OutputView();

	public void startRacing() {

		Cars cars = PlayerInputView.inputCarName();
		Round round = PlayerInputView.inputGameCount();

		outputView.printRacing(cars, round);


	}
}
