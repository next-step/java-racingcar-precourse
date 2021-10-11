package racinggame.controller;

import nextstep.utils.Console;
import racinggame.domain.Cars;
import racinggame.service.RacinggameService;
import racinggame.view.RacinggameView;

public class RacinggameController {
	private final RacinggameService racinggameService = new RacinggameService();
	private final RacinggameView racinggameView = new RacinggameView();

	private Cars cars = null;
	private int moveCount = 0;

	public RacinggameController() {
		
	}

	public void startGame() {
		getCarNameInput();
		getMoveCountInput();
		racinggameView.showPlayResultStartMessage();
		for (int i = 0; i < moveCount; i++) {
			cars.moveCars();
			racinggameView.showPlayResultMessage(cars);
			System.out.println();
		}
		racinggameView.showWinnerMessage(cars.getWinnerNames());
	}

	private void getCarNameInput() {
		try {
			racinggameView.showRequestCarNameInputMessage();
			cars = racinggameService.createCars(Console.readLine());
		} catch (IllegalArgumentException e) {
			racinggameView.showErrorMessage(e.getMessage());
			getCarNameInput();
		}
	}

	private void getMoveCountInput() {
		try {
			racinggameView.showRequestMoveCountInputMessage();
			String moveCountInput = Console.readLine();
			racinggameService.validateMoveCountInput(moveCountInput);
			moveCount = Integer.parseInt(moveCountInput);
		} catch (IllegalArgumentException e) {
			racinggameView.showErrorMessage(e.getMessage());
			getMoveCountInput();
		}
	}
}
