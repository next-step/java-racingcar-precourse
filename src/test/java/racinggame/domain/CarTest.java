package racinggame.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {
	@Test
	void 자동차_생성_시_입력된_이름이_그대로_출력되는지() {
		String carName = "자동차1";
		Car car = new Car(new CarName(carName));
		assertEquals(carName, car.getName());
	}

	@Test
	void 자동차_생성_시_위치는_0() {
		Car car = new Car(new CarName("자동차1"));
		assertEquals(0, car.getPosition());
	}

	@Test
	void 자동차_전진_시_이동하는_거리는_1_이하() {
		Car car = new Car(new CarName("자동차1"));
		for (int i = 0; i < 100; i++) {
			int beforePosition = car.getPosition();
			car.goForward();
			assertTrue(car.getPosition() - beforePosition <= 1);
		}
	}
}
