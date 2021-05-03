package io.github.redlasha.racingcar;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarEntriesTest {

	@Test
	void 자동차_엔트리는_문자열을_입력받아_카_목록을_가진다() { // @checkstyle:ignore
		String input = "abc,def,boron";

		CarEntries entries = new CarEntries(input);
		assertThat(entries.getCarList()).contains(new Car("abc"), new Car("def"), new Car("boron"));
	}

	@Test
	void 자동차_이름은_1이상_5이하여야_한다() { // @checkstyle:ignore
		String wrongInput = "wrongcar,valid,car";
		assertThrows(IllegalArgumentException.class, () -> {
			new CarEntries(wrongInput);
		});

		String emptyNameInput = ",valid,car";
		assertThrows(IllegalArgumentException.class, () -> {
			new CarEntries(emptyNameInput);
		});
	}

}
