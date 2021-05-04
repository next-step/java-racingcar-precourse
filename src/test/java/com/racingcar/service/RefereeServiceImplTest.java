package com.racingcar.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.racingcar.common.exception.RacingCarException;
import com.racingcar.common.message.Messages;
import com.racingcar.domain.RacingCar;
import com.racingcar.domain.RacingCarGroup;
import com.racingcar.domain.RacingCarMovingStatus;
import com.racingcar.service.dto.RacingCarDTO;

class RefereeServiceImplTest {

	@DisplayName("우승자 판별 테스트")
	@Test
	void testJudgeWinners() {
		RacingCar car1 = new RacingCar("TEST2");
		car1.move(RacingCarMovingStatus.GO);

		RacingCar car2 = new RacingCar("TEST1");
		car2.move(RacingCarMovingStatus.GO);

		RacingCar car3 = new RacingCar("TEST3");

		List<RacingCar> racingCarList = new ArrayList<>();
		racingCarList.add(car1);
		racingCarList.add(car2);
		racingCarList.add(car3);

		RacingCarGroup carGroup = new RacingCarGroup(racingCarList);

		RefereeService refereeService = new RefereeServiceImpl();
		assertEquals(Arrays.asList(new RacingCarDTO("TEST1"), new RacingCarDTO("TEST2")),
			refereeService.judge(carGroup));
	}

	@DisplayName("우승자 판별에 대한 예외 테스트")
	@Test
	void testJudgeException(){
		List<RacingCar> racingCarList = new ArrayList<>();
		RacingCarGroup carGroup = new RacingCarGroup(racingCarList);

		RefereeService refereeService = new RefereeServiceImpl();
		assertThatThrownBy(() -> refereeService.judge(carGroup)).isInstanceOf(RacingCarException.class)
			.hasMessage(Messages.JUDGE_WINNER_EXCEPTION);
	}

}