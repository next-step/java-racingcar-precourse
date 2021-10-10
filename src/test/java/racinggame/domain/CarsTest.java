package racinggame.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import nextstep.utils.Randoms;
import racinggame.message.ErrorMessage;

class CarsTest {
	@Test
	void 자동차_그룹에는_null이_들어오면_NullPointerException() {
		assertThrows(NullPointerException.class, () -> {
			Cars cars = new Cars();
			cars.addCar(null);
		});
	}

	@Test
	void 자동차_이름_중복_시_IllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> {
			addCarWithSameName();
		});
	}

	@Test
	void 자동차_이름_중복_시_SAME_CAR_NAME을_메시지로_반환하는지() {
		try {
			addCarWithSameName();
		} catch (IllegalArgumentException e) {
			assertEquals(ErrorMessage.SAME_CAR_NAME, ErrorMessage.valueOf(e.getMessage()));
		}
	}

	@Test
	void 자동차_그룹_생성_시_자동차의_대수는_0() {
		Cars cars = new Cars();
		assertEquals(0, cars.getQuantity());
	}

	@Test
	void 자동차_그룹에_차를_n대_추가하면_자동차의_대수는_n() {
		int n = Randoms.pickNumberInRange(0, 100);
		assertEquals(n, addRandomNumberOfCars(n).getQuantity());
	}

	private void addCarWithSameName() {
		Cars cars = new Cars();
		Car firstOne = new Car(new CarName("one"));
		cars.addCar(firstOne);
		Car secondOne = new Car(new CarName("one"));
		cars.addCar(secondOne);
	}

	private Cars addRandomNumberOfCars(int n) {
		Cars cars = new Cars();
		for (int i = 0; i < n; i++) {
			cars.addCar(new Car(new CarName("자동차" + i)));
		}
		return cars;
	}
}
