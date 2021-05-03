package io.github.redlasha.racingcar;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import io.github.redlasha.racingcar.CarName;

class CarNameTest {

	@Test
	void 자동차_이름은_getName으로_조회되어야_한다() { // @checkstyle:ignore
		String name = "abcde";
		CarName carName = new CarName(name);
		assertThat(carName.getName()).isEqualTo(name);
	}

	@Test
	void 자동차_이름은_null이_아니어야_한다() { // @checkstyle:ignore
		String nullName = null;
		assertThrows(IllegalArgumentException.class, () -> {
			new CarName(nullName);
		});
	}

	@Test
	void 자동차_이름은_1자_이상이어야_한다() { // @checkstyle:ignore
		String shortName = "";
		assertThrows(IllegalArgumentException.class, () -> {
			new CarName(shortName);
		});
	}

	@Test
	void 자동차_이름은_5자_이하여야_한다() { // @checkstyle:ignore
		String longName = "abcdef";
		assertThrows(IllegalArgumentException.class, () -> {
			new CarName(longName);
		});
	}

}
