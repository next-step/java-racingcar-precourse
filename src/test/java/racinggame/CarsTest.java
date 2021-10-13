package racinggame;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import racinggame.model.Car;
import racinggame.model.Cars;
import racinggame.model.Distance;

public class CarsTest {

	@Test
	void 자동차_이름_분할(){
		Cars cars = new Cars(Arrays.asList("chang,hyuk,park".split(",")));
		assertThat(cars.getNumberOfCars()).isEqualTo(3);
	}

	@Test
	void 자동차_최대_이동거리(){
		Distance maximunDistinct = new Distance(3);

		Car oneCar = new Car("chang");
		Car twoCar = new Car("hyuk");

		oneCar.move(6);
		twoCar.move(2);

		oneCar.move(9);
		twoCar.move(2);

		oneCar.move(7); // oneCar.getDistance() == 3
		twoCar.move(6); // twoCar.getDistance() == 2
		assertThat(maximunDistinct.getDistance() == oneCar.getDistance()).isTrue();
		assertThat(maximunDistinct.getDistance() == twoCar.getDistance()).isFalse();
	}

}
