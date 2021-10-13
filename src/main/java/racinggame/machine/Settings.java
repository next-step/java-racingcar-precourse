package racinggame.machine;

import racinggame.circuit.Lap;
import racinggame.circuit.RacingCars;

public final class Settings {
	private final RacingCars racingCars;
	private final Lap lap;

	public Settings(final RacingCars racingCars, final Lap lap) {
		this.racingCars = racingCars;
		this.lap = lap;
	}

	public RacingCars getRacingCars() {
		return racingCars;
	}

	public Lap getLap() {
		return lap;
	}
}
