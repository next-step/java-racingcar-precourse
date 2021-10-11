package racinggame.circuit;

import racinggame.ui.Circuit;
import racinggame.ui.Rule;

public class RacingCircuit implements Circuit {
	private final Rule rule;

	public RacingCircuit(Rule rule) {
		this.rule = rule;
	}

	@Override
	public FinalRecord start(RacingCars racingCars, Lap laps) {
		FinalRecord finalRecord = new FinalRecord();

		for (int lap = 0; lap < laps.getLaps(); ++lap) {
			finalRecord.add(racingCars.run());
		}

		return finalRecord;
	}
}
