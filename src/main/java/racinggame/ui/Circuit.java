package racinggame.ui;

import racinggame.common.Labs;
import racinggame.common.RacingCars;
import racinggame.common.ResultBoard;

public interface Circuit {
	ResultBoard start (RacingCars racingCars, Labs labs, Rule rule);
}
