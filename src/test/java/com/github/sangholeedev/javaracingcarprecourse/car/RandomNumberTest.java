package com.github.sangholeedev.javaracingcarprecourse.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberTest {

	RandomNumber randomNumber;

	@BeforeEach
	void 랜덤숫자_세팅() {
		randomNumber = new RandomNumber();
	}

	@Test
	@DisplayName("랜덤숫자_생성테스트")
	void 랜덤숫자_생성테스트() {
		assertThat(randomNumber).isNotNull();
	}

	@Test
	@DisplayName("랜덤숫자_조회_테스트")
	void 랜덤숫자_조회_테스트() {
		assertThat(randomNumber.getNumber()).isEqualTo(-1);
	}

	@Test
	@DisplayName("랜덤숫자_random값_생성테스트")
	void 랜덤숫자_random값_생성테스트() {
		// given
		randomNumber.generate();
		// when & then
		assertThat(randomNumber.getNumber()).isNotEqualTo(-1);
	}

	@Test
	@DisplayName("랜덤숫자_random값_0_9_사이테스트")
	void 랜덤숫자_random값_0_9_사이테스트() {
		// given
		randomNumber.generate();
		// when & then
		assertThat(randomNumber.getNumber()).isGreaterThanOrEqualTo(0);
		assertThat(randomNumber.getNumber()).isLessThanOrEqualTo(9);
	}

	@Test
	@DisplayName("랜덤숫자_random값_4이상_테스트")
	void 랜덤숫자_random값_4이상_테스트() {
		// given
		randomNumber.generate();
		// when & then
		assertThat(randomNumber.isGreaterThanOrEqualTo4()).isEqualTo(randomNumber.getNumber() >= 4);
	}
}