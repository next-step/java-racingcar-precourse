package domain.car.winner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import domain.car.result.CarMoveResult;
import domain.car.result.CarMoveResults;

public class Winners {

	private final List<Winner> winners = new ArrayList<>();

	private Winners(List<Winner> winners) {
		this.winners.addAll(winners);
	}

	public static Winners of(CarMoveResults results) {
		return new Winners(mapWinners(results));
	}

	private static List<Winner> mapWinners(CarMoveResults results) {
		List<Winner> mapWinners = new ArrayList<>();
		for (CarMoveResult carMoveResult : results.getMaxPositionCar()) {
			mapWinners.add(Winner.of(carMoveResult.getCarName()));
		}

		return mapWinners;
	}

	public List<Winner> getWinners() {
		return Collections.unmodifiableList(winners);
	}
}
