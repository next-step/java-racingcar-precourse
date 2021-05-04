package com.github.sangholeedev.javaracingcarprecourse.racing;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.github.sangholeedev.javaracingcarprecourse.player.Player;

class RaceTest {
	Race race;

	@BeforeEach
	void 레이스_초기세팅() {
		race = new Race(new Player("pobi,crong,honux"), new RaceCount(5));
	}

	@Test
	@DisplayName("레이트_생성_테스트")
	void 레이트_생성_테스트() {
		assertThat(race).isNotNull();
	}

}