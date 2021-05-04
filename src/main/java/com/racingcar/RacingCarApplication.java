package com.racingcar;

import com.racingcar.controller.RacingCarGameController;
import com.racingcar.domain.RandomRacingCarMovingStrategyImpl;
import com.racingcar.service.RacingCarMovingServiceImpl;
import com.racingcar.service.RacingCarServiceImpl;
import com.racingcar.service.RefereeServiceImpl;

public class RacingCarApplication {

	public static void main(String args[]) {
		RacingCarGameController racingCarGameController = RacingCarGameController.builder(new RacingCarServiceImpl(),
			new RacingCarMovingServiceImpl(new RandomRacingCarMovingStrategyImpl()), new RefereeServiceImpl()).build();

		racingCarGameController.play();
	}
}
