package racinggame.model;

import java.util.List;

public class WinnerTravel {
	private int winnerTravel;

	public WinnerTravel(List<Car> cars) {
		for (Car car : cars) {
			winnerTravel = Math.max(winnerTravel, car.getTotalTravel());
		}
	}

	public boolean isNotWinner(Car car) {
		return car.getTotalTravel() != winnerTravel;
	}

}
