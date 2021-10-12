package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DistanceTest {
	private Distance distance;

	@BeforeEach
	void init() {
		this.distance = new Distance();
	}

	@Test
	void 이동한_거리_랜덤값_4_이상() {
		distance.distance(Distance.COMPARE_NUMBER);
		assertThat(distance.value()).isEqualTo(1);
	}

	@Test
	void 이동한_거리_랜덤값_3_이하() {
		distance.distance(Distance.COMPARE_NUMBER - 1);
		assertThat(distance.value()).isEqualTo(0);
	}
}
