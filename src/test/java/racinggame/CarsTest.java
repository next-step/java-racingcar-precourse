package racinggame;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;
import static racinggame.common.CommonConstants.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import nextstep.utils.Randoms;
import racinggame.domain.Car;
import racinggame.domain.Cars;

public class CarsTest {

	Cars cars;

	@BeforeEach
	void setUp() {
		cars = new Cars();
		Car car = new Car("test");
		Car car2 = new Car("test2");
		cars.addCar(car);
		cars.addCar(car2);
	}

	@Test
	void 자동차들_추가() {
		Car car = new Car("addCar");

		cars.addCar(car);

		assertThat(cars.getCarList().size()).isEqualTo(3);

		cars.addCar(null);

		assertThat(cars.getCarList().size()).isEqualTo(3);
	}

	@Test
	void 자동차들_사이즈() {
		int answer = cars.getCarList().size();

		assertThat(cars.size()).isEqualTo(answer);
	}

	@Test
	void 레이싱() {
		final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class);
		mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
			.thenReturn(1,4);

		cars.racing();

		assertThat(cars.getCarList().get(0))
			.extracting("distance")
			.isEqualTo(0);
		assertThat(cars.getCarList().get(1))
			.extracting("distance")
			.isEqualTo(1);
	}

	@Test
	void 최대_이동거리() {
		final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class);
		mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
			.thenReturn(1,4,1,5,1,6);

		cars.racing();
		cars.racing();
		cars.racing();

		int max = cars.maxDistance();

		assertThat(max)
			.isEqualTo(3);
	}

	@Test
	void 문자열_표시() {
		final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class);
		mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
			.thenReturn(1,4,1,5,1,6);

		cars.racing();
		cars.racing();
		cars.racing();

		String carsString = cars.currentStatusString();

		assertThat(carsString)
			.startsWith("test")
			.contains(DISTANCE_STR)
			.contains("---")
			.contains("-");
	}

}
