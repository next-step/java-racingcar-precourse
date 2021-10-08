package racinggame.controller;

import racinggame.model.Cars;
import racinggame.view.InputView;

public class Controller {

	public void run() {

		Cars cars = new Cars(InputView.inputCarNames());

	}

}
