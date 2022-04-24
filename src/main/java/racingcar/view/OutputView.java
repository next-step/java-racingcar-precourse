package racingcar.view;

import racingcar.model.Car.Cars;
import racingcar.model.Winner;

public class OutputView {
	public static void resultPrint(Cars cars) {
		Winner winner = new Winner(cars);
		System.out.println(winner.print());
	}
}
