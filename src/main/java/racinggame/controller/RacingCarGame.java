package racinggame.controller;

import java.util.Arrays;

import racinggame.model.Car;
import racinggame.model.Cars;
import racinggame.view.InputVIew;
import racinggame.view.OutputVIew;

public class RacingCarGame {

	private static final String CAR_NAME_DELIMITER = ",";

	private final InputVIew inputVIew = new InputVIew();
	private final OutputVIew outputVIew = new OutputVIew();

	public void gameStart() {
		Cars cars = null;

		while (cars == null) {
			cars = makeCars(inputVIew.inputCarName());
		}

	}

	private Cars makeCars(String names) {
		Cars cars = null;
		try {
			cars = new Cars(Arrays.asList(names.split(CAR_NAME_DELIMITER)));
		} catch (Exception e) {
			outputVIew.outputErrorMessage(e.getMessage());
		}
		return cars;
	}

}
