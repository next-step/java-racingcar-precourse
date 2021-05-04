package com.racingcar.service;

import com.racingcar.common.exception.RacingCarException;
import com.racingcar.common.message.Messages;
import com.racingcar.domain.MovingSeed;
import com.racingcar.domain.RacingCar;
import com.racingcar.domain.RacingCarGroup;
import com.racingcar.domain.RacingCarMovingStatus;
import com.racingcar.domain.RacingCarMovingStrategy;

public class RacingCarMovingServiceImpl implements RacingCarMovingService {
	private static final int MAX = 9;
	private static final int MIN = 0;
	private static final int THRESHOLD = 4;

	private final RacingCarMovingStrategy strategy;

	public RacingCarMovingServiceImpl(RacingCarMovingStrategy strategy) {
		this.strategy = strategy;
	}

	@Override
	public void move(RacingCarGroup carGroup) {
		for (RacingCar car : carGroup.getRacingCarList()) {
			car.move(getMovingStatus(strategy.generate()));
		}
	}

	private RacingCarMovingStatus getMovingStatus(MovingSeed seed) {
		if (seed.getValue() < MIN || seed.getValue() > MAX) {
			throw new RacingCarException(Messages.INVALID_MOVING_SEED_MESSAGE);
		}
		return seed.getValue() >= THRESHOLD ? RacingCarMovingStatus.GO : RacingCarMovingStatus.STOP;
	}
}
