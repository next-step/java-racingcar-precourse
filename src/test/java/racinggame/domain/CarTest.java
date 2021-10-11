package racinggame.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("자동차 객체 Test")
class CarTest {

	@Test
	@DisplayName("현재 자동차 위치 반환 Test")
	void currentCars() {
		Car car = new Car("벤틀리");
		assertEquals(car.currentCars(), "벤틀리 : ");
	}
}