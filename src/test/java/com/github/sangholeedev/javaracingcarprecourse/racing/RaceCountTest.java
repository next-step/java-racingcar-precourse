package com.github.sangholeedev.javaracingcarprecourse.racing;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceCountTest {
	RaceCount raceCount;

	@BeforeEach
	void 초기레이트카운트_세팅() {
		raceCount = new RaceCount(5);
	}

	@Test
	@DisplayName("레이스카운트_생성_테스트")
	void 레이스카운트_생성_테스트() {
		assertThat(raceCount).isNotNull();
	}

	@Test
	@DisplayName("레이스카운트_횟수_조회_테스트")
	void 레이스카운트_횟수_조회_테스트() {
		assertThat(raceCount.getCount()).isEqualTo(5);
	}
}