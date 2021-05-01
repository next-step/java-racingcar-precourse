package com.racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LocationTest {

	private Location location;

	@BeforeEach
	void setUp() {
		location = Location.init();
	}

	@Test
	void 위치_0인_경우_시각화_테스트() {
		assertThat(location.visualize()).isEqualTo("");
	}

	@ParameterizedTest
	@CsvSource(value = {"0:''", "1:-", "2:--", "5:-----"}, delimiter = ':')
	void 위치_시각화_테스트(Integer locationIndex, String expect) {

		for (int i = 0; i < locationIndex; i++) {
			location.increase();
		}

		assertThat(location.visualize()).isEqualTo(expect);
	}
}