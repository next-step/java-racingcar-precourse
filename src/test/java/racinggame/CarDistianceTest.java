package racinggame;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.Test;

import racinggame.model.Distance;

public class CarDistianceTest {
	@Test
	void 위치값_불변성_확인() {
		Distance distance = new Distance(3);

		assertThat(distance.getDistance()).isEqualTo(3);
	}
}
