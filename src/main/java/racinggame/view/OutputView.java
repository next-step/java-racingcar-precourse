package racinggame.view;

import racinggame.common.ConstValue;
import racinggame.domain.Car;
import racinggame.domain.Cars;
import racinggame.domain.boxing.Round;

public class OutputView {

	public void printRacing(Cars cars, Round round) {

		System.out.println(ConstValue.OUTPUT_RACING_RESULT);

		for (int i = 0; i < round.getRoundCount(); i++) {
			printProcess(cars);
		}

		printWinner(cars);
	}

	private void printProcess(Cars cars) {
		for (Car car : cars.getCars()) {
			car.move();
			System.out.println(car.getMoveDistanceWithName());
		}
		System.out.println("\n");
	}

	private void printWinner(Cars cars) {
		cars.setWinner();

		System.out.println(
			ConstValue.OUTPUT_WINNER_MENT_START
				+ cars.getWinnerCars()
				+ ConstValue.OUTPUT_WINNER_MENT_END
		);
	}
}
