package io.github.redlasha.racingcar;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class RandomDiceTest {

	@RepeatedTest(value = 100)
	void 랜덤넘버는_0부터_9까지의_수중에서_선택된다() { // @checkstyle:ignore
		RandomDice rn = new RandomDice();
		int number = rn.nextNumber();
		assertThat(number).isBetween(0, 9);
	}

	@Test
	void nextNumberList는_size_만큼_0에서_9까지_조건을_만족하는_랜덤_수_리스트를_생성한다() { // @checkstyle:ignore
		int size = 3;
		RandomDice rd = new RandomDice();
		List<Integer> list = rd.nextNumberList(size);
		assertThat(list.size()).isEqualTo(size);
		assertThat(list).allMatch(number -> {
			return 0 <= number.intValue() && number.intValue() <= 9;
		});
	}

}
