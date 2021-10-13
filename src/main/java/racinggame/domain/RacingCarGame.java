package racinggame.domain;

import java.util.List;

import racinggame.strategy.MovingStrategy;
import racinggame.utils.RacingCarGenerator;

public class RacingCarGame {
	private Cars cars;

	public RacingCarGame(RacingCarNames names) {
		cars = RacingCarGenerator.generate(names.parse());
	}

	public void run(MovingStrategy strategy) {
		cars.race(strategy);
	}

	public GameReport report() {
		return new GameReport(cars.report());
	}

	public List<CarDto> reportPosition() {
		return cars.report();
	}
}