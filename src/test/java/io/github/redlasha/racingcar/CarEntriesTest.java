package io.github.redlasha.racingcar;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

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

	@Test
	void 자동차_엔트리는_숫자_리스트로_각_자동차의_진행을_결정한다() { // @checkstyle:ignore
		String input = "abc,def,boron";

		CarEntries entries = new CarEntries(input);
		entries.moveTurn(Arrays.asList(4, 4, 4));
		assertThat(entries.getCarList()).allMatch(car -> {
			return car.getDistance().equals(new Distance(1));
		});

		entries.moveTurn(Arrays.asList(3, 3, 3));
		assertThat(entries.getCarList()).allMatch(car -> {
			return car.getDistance().equals(new Distance(1));
		});
	}

	@Test
	void 자동차_엔트리는_차의_개수를_조회할수_있다() { // @checkstyle:ignore
		String input = "abc,def,boron";

		CarEntries entries = new CarEntries(input);
		assertThat(entries.size()).isEqualTo(3);
	}

	@Test
	void getLongestDistance_메서드로_가장_멀리간_거리를_구할수_있다() { // @checkstyle:ignore
		String input = "abc,def,boron";

		CarEntries entries = new CarEntries(input);
		entries.moveTurn(Arrays.asList(4, 4, 4));
		entries.moveTurn(Arrays.asList(4, 3, 3));
		entries.moveTurn(Arrays.asList(4, 3, 4));

		assertThat(entries.getLongestDistance()).isEqualTo(new Distance(3));
	}

	@Test
	void getWinners_메서드로_우승자를_구할수_있다() { // @checkstyle:ignore
		String input = "abc,def,boron";

		CarEntries entries = new CarEntries(input);
		entries.moveTurn(Arrays.asList(4, 4, 4));
		entries.moveTurn(Arrays.asList(4, 3, 3));
		entries.moveTurn(Arrays.asList(4, 3, 4));

		assertThat(entries.getWinners()).contains(new Car("abc"));
	}

	@Test
	void getWinners_메서드는_중복_우승자도_허용한다() { // @checkstyle:ignore
		String input = "abc,def,boron";

		CarEntries entries = new CarEntries(input);
		entries.moveTurn(Arrays.asList(4, 4, 4));
		entries.moveTurn(Arrays.asList(4, 3, 3));
		entries.moveTurn(Arrays.asList(4, 3, 4));
		entries.moveTurn(Arrays.asList(3, 3, 4));

		assertThat(entries.getWinners()).contains(new Car("abc"), new Car("boron"));
	}
}
