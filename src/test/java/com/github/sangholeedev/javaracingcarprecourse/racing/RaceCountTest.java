package com.github.sangholeedev.javaracingcarprecourse.racing;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceCountTest {
	@Test
	@DisplayName("레이스카운트_생성_테스트")
	void 레이스카운트_생성_테스트() {
		RaceCount raceCount = new RaceCount();
		assertThat(raceCount).isNotNull();
	}
}