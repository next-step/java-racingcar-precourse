package nextstep.controller;

import nextstep.racingcar.RacingCars;
import nextstep.trycount.TryCount;

public class RacingGameController {

	public static void play() {
		final RacingCars racingCars = RacingCarInitController.init();
		final TryCount tryCount = TryCountInitController.init();
	}


}
