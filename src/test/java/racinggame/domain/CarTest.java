package racinggame.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("자동차 객체 Test")
class CarTest {

	@Test
	@DisplayName("현재 자동차 위치 반환 Test")
	void currentCarsTest() {
		Car car = new Car("벤틀리");
		assertEquals(car.currentCars(), "벤틀리 : ");
	}

	@Test
	@DisplayName("현재 자동차 위치 정수 반환 Test")
	void currentCarsToIntTest() {
		Car car = new Car("벤틀리");
		assertEquals(car.currentCarsToInt(), 0);
	}

	@Test
	@DisplayName("자동차 이름 반환 Test")
	void getCarNameTest() {
		Car car = new Car("벤츠");
		assertEquals(car.getCarName(), "벤츠");
	}
}