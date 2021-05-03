package io.github.redlasha.racingcar;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RacingTurnTest {

	@Test
	void RacingTurn은_입력받은_수만큼_반복한다() { // @checkstyle:ignore
		int input = 5;
		RacingTurn turn = new RacingTurn(input);

		int count = 0;
		while (turn.next()) {
			count++;
		}

		assertThat(count).isEqualTo(input);
	}

	@Test
	void RacingTurn은_양의정수만_입력가능하다() { // @checkstyle:ignore
		assertThrows(IllegalArgumentException.class, () -> {
			new RacingTurn(0);
		});

		assertThrows(IllegalArgumentException.class, () -> {
			new RacingTurn(-1);
		});
	}

}
