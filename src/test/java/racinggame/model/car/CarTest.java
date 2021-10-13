package racinggame.model.car;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
	@Test
	void 차생성테스트() {
		String carName = "test_name";
		Car car = new Car(carName);
		assertEquals(carName, car.getName());
	}

	@Test
	void 이동테스트(){
		// given
		String name = "test";
		Car car = new Car(name);

		// when
		for(int i = 0; i < 6; i++){
			car.move();
		}

		// then
		assertEquals(true, car.getPosition() > 0 && car.getPosition() < 6);
	}
}
