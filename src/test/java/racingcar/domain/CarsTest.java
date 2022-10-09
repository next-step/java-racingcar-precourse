package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

	private static final int FORWARD_NUM = 4;

	@Test
	@DisplayName("자동차가 생성된다.")
	void init() {
		List<Car> carList = new ArrayList<>();
		carList.add(new Car(new Name("pobi")));
		carList.add(new Car(new Name("crong")));

		Cars cars = new Cars(carList);
		assertThat(cars.getCars()).hasSize(2);
	}

	@Test
	@DisplayName("자동차가 모두 전진한다.")
	void move() {
		Cars cars = getForwardCars("pobi", "crong");
		cars.move();
		for (Car car : cars.getCars()) {
			assertThat(car.getPosition()).isEqualTo(1);
		}
	}

	private Cars getForwardCars(String... names) {
		List<Car> cars = new ArrayList<>();
		for (String name : names) {
			cars.add(getForwardCar(name));
		}
		return new Cars(cars);
	}

	private Car getForwardCar(String name) {
		return new Car(new Name(name)) {
			@Override
			protected int getRandomNo() {
				return FORWARD_NUM;
			}
		};
	}
}