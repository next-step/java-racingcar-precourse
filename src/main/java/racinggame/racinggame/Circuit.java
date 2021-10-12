package racinggame.racinggame;

import racinggame.circuit.FinalRecord;
import racinggame.circuit.Lap;
import racinggame.circuit.RacingCars;

public interface Circuit {
	FinalRecord start(RacingCars racingCars, Lap laps);
}
