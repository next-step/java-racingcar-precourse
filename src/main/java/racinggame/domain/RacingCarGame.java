package racinggame.domain;

import java.util.List;

import racinggame.strategy.MovingStrategy;
import racinggame.utils.RacingCarGenerator;

public class RacingCarGame {
	private RacingCars racingCars;

	public RacingCarGame(RacingCarNames names) {
		racingCars = RacingCarGenerator.generate(names.parse());
	}

	public void race(MovingStrategy strategy) {
		racingCars.race(strategy);
	}

	public GameReport report() {
		return new GameReport(racingCars.report());
	}

	public List<RacingCarDto> reportPosition() {
		return racingCars.report();
	}
}