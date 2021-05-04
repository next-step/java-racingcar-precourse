package com.github.sangholeedev.javaracingcarprecourse.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberTest {

	@Test
	@DisplayName("랜덤숫자_생성테스트")
	void 랜덤숫자_생성테스트() {
		RandomNumber randomNumber = new RandomNumber();
		assertThat(randomNumber).isNotNull();
	}
}