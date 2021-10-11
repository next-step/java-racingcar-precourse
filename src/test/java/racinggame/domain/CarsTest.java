package racinggame.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

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
		assertEquals(n, addCars(n).getQuantity());
	}

	@Test
	void 인덱스로_자동차_상태_조회_시_기존_자동차_객체와_같은_상태가_반환되는지() {
		Cars cars = new Cars();
		Car car = new Car(new CarName("one"));
		CarStatus originalStatus = new CarStatus(car);
		cars.addCar(car);
		assertEquals(originalStatus, cars.getCarStatusByIndex(0));
	}

	@Test
	void 모든_자동차_이동_시_이동거리는_0부터_9_사이() {
		Cars cars = addCars(100);
		cars.moveCars();
		ArrayList<Integer> afterPositions = getCarPositions(cars);
		if (isAllZero(afterPositions)) {
			모든_자동차_이동_시_이동거리는_0부터_9_사이();
		}
		for (int i = 0; i < afterPositions.size(); i++) {
			assertTrue(afterPositions.get(i) >= 0 && afterPositions.get(i) <= 9);
		}
	}

	private void addCarWithSameName() {
		Cars cars = new Cars();
		Car firstOne = new Car(new CarName("one"));
		cars.addCar(firstOne);
		Car secondOne = new Car(new CarName("one"));
		cars.addCar(secondOne);
	}

	private Cars addCars(int n) {
		Cars cars = new Cars();
		for (int i = 0; i < n; i++) {
			cars.addCar(new Car(new CarName("자동차" + i)));
		}
		return cars;
	}

	private ArrayList<Integer> getCarPositions(Cars cars) {
		ArrayList<Integer> carPositions = new ArrayList<>();
		for (int i = 0; i < cars.getQuantity(); i++) {
			carPositions.add(cars.getCarStatusByIndex(i).getCarPosition());
		}
		return carPositions;
	}

	private boolean isAllZero(ArrayList<Integer> carPositions) {
		ArrayList<Integer> zeros = new ArrayList<>();
		for (int i = 0; i < carPositions.size(); i++) {
			zeros.add(0);
		}
		return carPositions.equals(zeros);
	}
}
