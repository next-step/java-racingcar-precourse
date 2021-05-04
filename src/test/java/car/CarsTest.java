package car;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

	private Cars cars;

	@BeforeEach
	void setUp() {
		cars = new Cars("pobi,crong,honux");
	}

	@Test
	@DisplayName("자동차 몇대 인지 확인")
	void countCar() {
		assertThat(cars.getCarCount()).isEqualTo(3);
	}

	@Test
	@DisplayName("자동차들이 전부 움직였는지 확인")
	void moveForwardAll() {
		cars.race(Arrays.asList(4, 5, 8));
		for (Car car : cars.callCarList()) {
			assertThat(car.getCarIndex().getIndex()).isEqualTo(1);
		}
	}

	@Test
	@DisplayName("자동차들이 일부만 움직였는지 확인")
	void moveForwardPartly() {
		cars.race(Arrays.asList(4, 3, 8));
		assertThat(cars.callCarList().get(0).getCarIndex().getIndex()).isEqualTo(1);
		assertThat(cars.callCarList().get(1).getCarIndex().getIndex()).isEqualTo(0);
		assertThat(cars.callCarList().get(2).getCarIndex().getIndex()).isEqualTo(1);
	}

	@Test
	@DisplayName("자동차들이 전혀 움직이지 않았는지 확인")
	void moveStop() {
		cars.race(Arrays.asList(3, 1, 2));
		for (Car car : cars.callCarList()) {
			assertThat(car.getCarIndex().getIndex()).isEqualTo(0);
		}
	}

	@Test
	@DisplayName("자동차들 움직임을 눈으로 확인")
	void showCarIndex() {
		cars.race(Arrays.asList(0, 5, 8));
		cars.showCarsIndex();
		cars.race(Arrays.asList(2, 6, 3));
		cars.showCarsIndex();
		cars.race(Arrays.asList(1, 7, 5));
		cars.showCarsIndex();
	}
}
