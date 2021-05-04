package com.github.sangholeedev.javaracingcarprecourse.player;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

	@Test
	@DisplayName("사용자_경주자동차이름_입력")
	void 사용자_경주자동차이름_입력() {
		final String carNameString = "pobi,crong,honux";
		Player player = new Player(carNameString);
		assertThat(player.getCarNames()).hasSize(3);
	}
}