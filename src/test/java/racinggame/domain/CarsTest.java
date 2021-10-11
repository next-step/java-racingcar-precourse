package racinggame.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import nextstep.utils.Randoms;
import racinggame.message.ErrorMessage;

class CarsTest {
	@Test
	void null인_자동차_리스트가_들어오면_NullPointerException() {
		assertThrows(NullPointerException.class, () -> {
			new Cars(null);
		});
	}

	@Test
	void 자동차_리스트에_null이_있으면_NullPointerException() {
		assertThrows(NullPointerException.class, () -> {
			new Cars(Arrays.asList(new Car(new CarName("a")), null));
		});
	}

	@Test
	void 자동차_이름_중복_시_IllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Cars(createCarListWithDuplicateCarNames());
		});
	}

	@Test
	void 자동차_이름_중복_시_SAME_CAR_NAME을_메시지로_반환하는지() {
		try {
			new Cars(createCarListWithDuplicateCarNames());
		} catch (IllegalArgumentException e) {
			assertEquals(ErrorMessage.DUPLICATE_CAR_NAMES, ErrorMessage.valueOf(e.getMessage()));
		}
	}

	@Test
	void 자동차_대수_조회_시_자동차_그룹_생성_시의_자동차_대수와_같은지() {
		assertEquals(100, new Cars(createCarList(100)).getCarsCount());
	}

	@Test
	void 인덱스로_자동차_상태_조회_시_기존_자동차_객체와_같은_상태가_반환되는지() {
		Car car = new Car(new CarName("one"));
		CarStatus originalStatus = new CarStatus(car);
		Cars cars = new Cars(Arrays.asList(car));
		assertEquals(originalStatus, cars.getCarStatusByIndex(0));
	}

	@Test
	void 모든_자동차_이동_시_이동거리는_1_이하() {
		Cars cars = new Cars(createCarList(100));
		ArrayList<Integer> beforePositions = null;
		while (checkCarPositionsAllZero(cars)) {
			beforePositions = getCarPositions(cars);
			cars.moveCars();
		}
		for (int i = 0; i < cars.getCarsCount(); i++) {
			assertTrue(getCarPositions(cars).get(i) - beforePositions.get(i) <= 1);
		}
	}

	@Test
	void 우승한_자동차는_1대_이름은_우승자() {
		List<Car> carList = createCarList(100);
		carList.add(createWinnerCar("우승자"));
		Cars cars = new Cars(carList);
		assertEquals(1, cars.getWinnerNames().split(",").length);
		assertEquals("우승자", cars.getWinnerNames());
	}

	@Test
	void 우승한_자동차는_2대_이름은_a_b() {
		List<Car> carList = createCarList(100);
		carList.add(createWinnerCar("a"));
		carList.add(createWinnerCar("b"));
		Cars cars = new Cars(carList);
		assertEquals(2, cars.getWinnerNames().split(",").length);
		assertEquals("a,b", cars.getWinnerNames());
	}

	private List<Car> createCarListWithDuplicateCarNames() {
		return Arrays.asList(new Car(new CarName("a")), new Car(new CarName("a")));
	}

	private List<Car> createCarList(int n) {
		List<Car> cars = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			cars.add(new Car(new CarName("c" + i)));
		}
		return cars;
	}

	private ArrayList<Integer> getCarPositions(Cars cars) {
		ArrayList<Integer> carPositions = new ArrayList<>();
		for (int i = 0; i < cars.getCarsCount(); i++) {
			carPositions.add(cars.getCarStatusByIndex(i).getCarPosition());
		}
		return carPositions;
	}

	private boolean checkCarPositionsAllZero(Cars cars) {
		int zeroCount = 0;
		for (int i = 0; i < cars.getCarsCount(); i++) {
			zeroCount = cars.getCarStatusByIndex(i).getCarPosition() == 0 ? zeroCount + 1 : zeroCount;
		}
		return zeroCount == cars.getCarsCount();
	}

	private Car createWinnerCar(String carName) {
		try (MockedStatic<Randoms> mockRandoms = Mockito.mockStatic(Randoms.class)) {
			mockRandoms.when(() -> Randoms.pickNumberInRange(Mockito.anyInt(), Mockito.anyInt())).thenReturn(4);
			Car winner = new Car(new CarName(carName));
			winner.goForward();
			return winner;
		}
	}
}
