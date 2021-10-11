package racinggame.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("자동차 컬렉션 객체 Test")
class RacingCarsTest {

	@Test
	@DisplayName("자동차 추가 Test")
	void addCarTest() {
		RacingCars racingCars = new RacingCars();
		assertEquals(0, racingCars.getRacingCars().size());
		Car car = new Car("재규어");
		racingCars.addCar(car);
		assertEquals(1, racingCars.getRacingCars().size());
	}
}