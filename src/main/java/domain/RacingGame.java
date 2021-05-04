package domain;

import java.util.ArrayList;
import java.util.List;

import view.OutputView;

public class RacingGame {
	private List<RacingCar> RacingCars;
	public int roundCount;

	public RacingGame(String[] carNames, int roundCount) {
		RacingCars = new ArrayList<RacingCar>();
		this.roundCount = roundCount;
		for (String carName : carNames) {
			RacingCars.add(new RacingCar(carName));
		}
	}

	public void run() {
		for (int round = 0; round < roundCount; round++) {
			for (RacingCar car : RacingCars) {
				car.move();
			}
		}
	}

}
