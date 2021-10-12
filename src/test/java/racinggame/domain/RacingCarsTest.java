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
		Car jaguar = new Car("재규어");
		racingCars.addCar(jaguar);
		assertEquals(1, racingCars.getRacingCars().size());
	}

	@Test
	@DisplayName("자동차 추가 Test")
	void convertToStringTest() {
		RacingCars racingCars = new RacingCars();
		Car jaguar = new Car("재규어");
		Car ferrari = new Car("페라리");
		Car kia = new Car("기아");
		racingCars.addCar(jaguar);
		racingCars.addCar(ferrari);
		racingCars.addCar(kia);
		assertEquals("재규어, 페라리, 기아", racingCars.convertToString());
	}
}