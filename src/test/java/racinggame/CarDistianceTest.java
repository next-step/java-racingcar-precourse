package racinggame;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.Test;

import racinggame.model.CarDistiance;

public class CarDistianceTest {
	@Test
	void 위치값_불변성_확인(){
		CarDistiance distance = new CarDistiance(3);

		assertThat(distance.getDistiance()).isEqualTo(3);
	}
}
