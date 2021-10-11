package racinggame.controller;

import racinggame.domain.Cars;
import racinggame.view.PlayerInputView;

public class RacingGameController {

	public void startRacing() {

		while(true) {
			Cars cars = PlayerInputView.inputCarName();

		}
	}
}
