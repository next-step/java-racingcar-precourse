package racinggame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import racinggame.model.CarDistance;

public class CarDistanceTest {
	@Test
	void 자동차_거리는_1씩_증가() {
		int beforeDistance = 0;
		CarDistance carDistance = new CarDistance(beforeDistance);
		carDistance.update();

		assertThat(carDistance.getDistance()).isEqualTo(beforeDistance + 1);
	}
}
