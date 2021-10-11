package racinggame.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("자동차 위치 객체 Test")
class CarPositionTest {

	@Test
	@DisplayName("위치 이동 Test")
	void movePositionTest() {
		CarPosition carPosition = new CarPosition();
		carPosition.movePosition();
		assertEquals(carPosition.getCarPosition(), "-");
	}
}