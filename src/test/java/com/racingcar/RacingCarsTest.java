package com.racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RacingCarsTest {

	@Test
	void 이름_하나만_받는_경우() {
		String input = "test1";

		RacingCars result = RacingCars.of(input);

		assertThat(result.count()).isEqualTo(1);

		assertThat(result.getValue().get(0).getName().getValue()).isEqualTo("test1");
		assertThat(result.getValue().get(0).getLocation().getValue()).isEqualTo(0);
	}

	@Test
	void 이름_2개_받는_경우() {
		String input = "test1,test2";

		RacingCars result = RacingCars.of(input);

		assertThat(result.count()).isEqualTo(2);

		assertThat(result.getValue().get(0).getName().getValue()).isEqualTo("test1");
		assertThat(result.getValue().get(0).getLocation().getValue()).isEqualTo(0);

		assertThat(result.getValue().get(1).getName().getValue()).isEqualTo("test2");
		assertThat(result.getValue().get(1).getLocation().getValue()).isEqualTo(0);
	}
}