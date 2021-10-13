package racinggame.model;

import java.util.ArrayList;
import java.util.List;

public class ParticipationCars {
	private final List<Car> cars;

	public ParticipationCars() {
		cars = new ArrayList<>();
	}

	public void enterRace(final Car car) {
		cars.add(car);
	}

	public RoundResult startRound() {
		RoundResult roundResult = new RoundResult(new StringBuilder());
		for (Car car : cars) {
			car.move(car.chooseAction());
			roundResult.appendRoundResult(car);
		}
		return roundResult;
	}

	public Winner createWinner() {
		int winnerPosition = getWinnerPosition();
		Winner winner = new Winner();
		for (Car car : cars) {
			winner.addWinnerInNotNull(getNameIfWinner(winnerPosition, car));
		}
		return winner;
	}

	private Car getNameIfWinner(final int winnerPosition, final Car car) {
		if (car.getPosition() == winnerPosition) {
			return car;
		}
		return null;
	}

	private int getWinnerPosition() {
		int winnerPosition = 0;
		for (Car car : cars) {
			winnerPosition = Math.max(winnerPosition, car.getPosition());
		}
		return winnerPosition;
	}
}
