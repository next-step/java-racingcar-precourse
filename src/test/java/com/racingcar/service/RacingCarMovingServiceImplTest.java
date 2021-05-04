package com.racingcar.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.racingcar.common.exception.RacingCarException;
import com.racingcar.common.message.Messages;
import com.racingcar.domain.MockMovingStrategy;
import com.racingcar.domain.RacingCar;
import com.racingcar.domain.RacingCarGroup;

class RacingCarMovingServiceImplTest {
	private RacingCarGroup carGroup;

	private
	@BeforeEach
	void setUp() {
		carGroup = new RacingCarGroup(Arrays.asList(new RacingCar("Test")));

	}

	@DisplayName("자동차가 앞으로 가는지 테스트")
	@ParameterizedTest
	@ValueSource(ints = {4, 5, 6})
	void testGoCar(int seed) {
		MockMovingStrategy mockMovingStrategy = new MockMovingStrategy(seed);
		RacingCarMovingService movingService = new RacingCarMovingServiceImpl(mockMovingStrategy);

		movingService.move(carGroup);

		assertEquals(1, carGroup.getRacingCarList().get(0).getMoveCount());
	}

	@DisplayName("자동차가 멈춰있는지 테스트")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	void testStopCar(int seed) {
		MockMovingStrategy mockMovingStrategy = new MockMovingStrategy(seed);
		RacingCarMovingService movingService = new RacingCarMovingServiceImpl(mockMovingStrategy);

		movingService.move(carGroup);

		assertEquals(0, carGroup.getRacingCarList().get(0).getMoveCount());
	}

	@DisplayName("입력받은 Seed의 값이 범위를 벗어나는 경우에 대한 예외처리 테스트")
	@ParameterizedTest
	@ValueSource(ints = {-1, 0, 10})
	void testMovingException(int seed) {
		MockMovingStrategy mockMovingStrategy = new MockMovingStrategy(seed);
		RacingCarMovingService movingService = new RacingCarMovingServiceImpl(mockMovingStrategy);

		assertThatThrownBy(() -> movingService.move(carGroup)).isInstanceOf(RacingCarException.class)
			.hasMessage(Messages.INVALID_MOVING_SEED_MESSAGE);
	}

}