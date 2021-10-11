package racinggame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racinggame.domain.Car;
import racinggame.domain.Cars;

public class CarsTest {

	Cars cars;

	@BeforeEach
	void setUp() {
		cars = new Cars();
	}

	@Test
	void 자동차들_추가() {
		Car car = new Car("test");

		cars.addCar(car);

		assertThat(cars.getCarList().size()).isEqualTo(1);

		cars.addCar(null);

		assertThat(cars.getCarList().size()).isEqualTo(1);
	}

}
