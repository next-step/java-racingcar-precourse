package racinggame;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.Test;

import racinggame.model.CarPosition;

public class CarPositionTest {
	@Test
	void 위치값_불변성_확인(){
		CarPosition position = new CarPosition(3);

		assertThat(position.getPosition()).isEqualTo(3);
	}
}
