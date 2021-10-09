package racinggame.model;

import java.util.Collections;
import java.util.List;

public class Round {

	private static final int FINISH_ROUND_COUNT = 0;
	private static final RoundCount FINISH_ROUND = new RoundCount(FINISH_ROUND_COUNT);

	private final RoundCount roundCount;
	private final Cars cars;

	public Round(Cars cars, int countOfRound) {
		this.cars = cars;
		this.roundCount = new RoundCount(countOfRound);
	}

	public Round play() {
		return new Round(this.cars.move(), this.roundCount.decrease());
	}

	public Winners findWinners() {
		return this.cars.findWinners();
	}

	public List<Car> getCars() {
		return Collections.unmodifiableList(this.cars.getCars());
	}

	public boolean isFinishRound() {
		return FINISH_ROUND.equals(this.roundCount);
	}
}