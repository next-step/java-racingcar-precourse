package racinggame;

import static org.assertj.core.api.Assertions.*;
import static racinggame.common.CommonConstants.*;

import org.junit.jupiter.api.Test;

import racinggame.domain.Distance;

public class DistanceTest {
	@Test
	void 전진() {
		Distance distance = new Distance();
		distance.plus();
		distance.plus();

		assertThat(distance.getDistance()).isEqualTo(2);
	}

	@Test
	void 문자열_표현() {
		Distance distance = new Distance();
		distance.plus();
		distance.plus();

		assertThat(distance).asString().isEqualTo(DISTANCE_STR + DISTANCE_STR);
	}
}
