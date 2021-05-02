package io.github.redlasha.racingcar;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DistanceTest {

	@Test
	void 거리는_한번_움질일때_1만큼_움직인다() {
		Distance distance = new Distance();
		distance.add();
		assertThat(distance.get()).isEqualTo(1);

		distance.add();
		assertThat(distance.get()).isEqualTo(2);
	}

}
