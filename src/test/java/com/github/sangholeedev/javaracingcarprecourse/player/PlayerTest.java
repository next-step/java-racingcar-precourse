package com.github.sangholeedev.javaracingcarprecourse.player;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {
	@Test
	@DisplayName("사용자_생성테스트")
	void 사용자_생성테스트() {
		Player player = new Player();
		assertThat(player).isNotNull();
	}
}