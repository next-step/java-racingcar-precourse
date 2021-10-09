package racinggame.ui;

import racinggame.common.Lap;
import racinggame.common.RacingCars;
import racinggame.common.ResultBoard;

public interface Circuit {
	ResultBoard start (RacingCars racingCars, Lap lap, Rule rule);
}
