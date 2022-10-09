package racingcar.view;

import java.util.List;

import racingcar.domain.Car;
import racingcar.io.Input;
import racingcar.io.Output;
import racingcar.message.ErrorMessage;
import racingcar.message.GameMessage;
import racingcar.util.CarsUtils;

public class GameView {
	private final Input input;
	private final Output output;

	public GameView(Input input, Output output) {
		this.input = input;
		this.output = output;
	}

	public String inputCarNames() {
		output.printGameMessage(GameMessage.INPUT_CAR_NAMES);
		String carNames = "";
		do {
			carNames = input.getString();
		} while (!validateCarNames(carNames));
		return carNames;
	}

	private boolean validateCarNames(String carNames) {
		if (!CarsUtils.validateCarNames(carNames)) {
			output.printErrorMessage(ErrorMessage.INPUT_CAR_NAMES_ERROR);
			return false;
		}
		return true;
	}

	public int inputTryNo() {
		output.printGameMessage(GameMessage.INPUT_TRY_NO);
		String tryNo = "";
		do {
			tryNo = input.getString();
		} while (!validateTryNo(tryNo));
		return Integer.parseInt(tryNo);
	}

	private boolean validateTryNo(String tryNo) {
		if (!CarsUtils.validateTryNo(tryNo)) {
			output.printErrorMessage(ErrorMessage.INPUT_TRY_NO_ERROR);
			return false;
		}
		return true;
	}

	public void printRacingResult() {
		output.printGameMessage(GameMessage.RACING_RESULT);
	}

	public void printCars(List<Car> cars) {
		for (Car car : cars) {
			String name = car.getName();
			String position = car.getPosition().getPositionToBar();
			output.printGameMessage(GameMessage.RACING_CAR, name, position);
		}
		output.printNewLine();
	}
}
