package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {

	@Test
	void createCarTest() {
		String carName = "test-car";
		Car car = new Car(carName);
		assertEquals(carName, car.getName());
	}
}
