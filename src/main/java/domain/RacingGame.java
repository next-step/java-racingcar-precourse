package domain;

import java.util.ArrayList;
import java.util.List;

import view.OutputView;

public class RacingGame {
	private List<RacingCar> RacingCars;
	private int winnerPosition;
	private List<String> Winners;
	public int roundCount;

	public RacingGame(String[] carNames, int roundCount) {
		RacingCars = new ArrayList<RacingCar>();
		Winners = new ArrayList<String>();
		winnerPosition = 0;
		this.roundCount = roundCount;
		for (String carName : carNames) {
			RacingCars.add(new RacingCar(carName));
		}
	}

	public void run() {
		for (int round = 0; round < roundCount; round++) {
			for (RacingCar car : RacingCars) {
				car.move();
				if (car.isCarPositionBigger(winnerPosition))
					winnerPosition = car.getCarPosition();
			}
			OutputView.printNewLine();
		}
		findWinner();
		printResult();
	}

	public void findWinner() {
		for (RacingCar car : RacingCars) {
			if (car.isSamePosition(winnerPosition)) {
				Winners.add(car.getCarName());
			}
		}
	}

	public void printResult() {
		OutputView.printWinner(Winners);
	}
}
