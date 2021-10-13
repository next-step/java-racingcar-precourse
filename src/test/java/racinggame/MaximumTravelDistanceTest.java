package racinggame;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.Test;

import racinggame.model.MaximumTravelDistance;

public class MaximumTravelDistanceTest {
	@Test
	void 최대이동거리_확인() {
		MaximumTravelDistance maximumTravelDistance = new MaximumTravelDistance(3);

		assertThat(maximumTravelDistance.getMaximumTravelDistance()).isEqualTo(3);
	}
}
