package com.gotgolem.racingcar.service;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import com.gotgolem.racingcar.asset.Cars;

public class PlayerServiceTest {

	private PlayerService playerService;

	@BeforeEach
	public void init() {
		playerService = new PlayerService();
	}

	@Test
	public void toCarsFromCsv() {
		final String csv = " pobi  ,,crong , honux";
		final Cars cars = playerService.toCars(csv);

		assertThat(cars.size())
				.isEqualTo(3);
		assertThat(cars.getCar(0).getName())
				.isEqualTo("pobi");
		assertThat(cars.getCar(1).getName())
				.isEqualTo("crong");
		assertThat(cars.getCar(2).getName())
				.isEqualTo("honux");
	}

	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = {",,", ", , ", "1,2,3,4,5,6,7,8,9,10,11", "apples, abc"})
	public void toCarsFailCase(final String csv) {
		assertThatIllegalArgumentException()
				.as("1-10개의 자동차 생성 가능 & 자동차의 이름은 5글자 미만")
				.isThrownBy(() -> playerService.toCars(csv));
	}

}
