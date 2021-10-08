package racinggame.controller;

import racinggame.model.Cars;
import racinggame.model.TryCount;
import racinggame.view.InputView;

public class Controller {

	public void run() {

		Cars cars = new Cars(InputView.inputCarNames());
		TryCount tryCount = new TryCount(InputView.inputRaceTryCount());

	}

}
