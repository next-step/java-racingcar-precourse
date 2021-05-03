package com.racingcar.service;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.racingcar.common.exception.RacingCarException;
import com.racingcar.common.message.Messages;

class RacingCarServiceImplTest {

	@DisplayName("예외처리_검사")
	@ParameterizedTest
	@ValueSource(strings = {"","a,a,a", "aa, , ",",","aaaaaaaa,"})
	public void checkException(String input) {
		RacingCarService racingCarService = new RacingCarServiceImpl();
		assertThatThrownBy(() ->racingCarService.create(input)).isInstanceOf(RacingCarException.class)
			.hasMessage(Messages.ERROR_MESSAGE);
	}
}