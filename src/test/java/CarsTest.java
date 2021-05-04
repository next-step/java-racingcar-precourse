import static javax.swing.border.TitledBorder.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarsTest {

	private static final int CARS_COUNT = 3;

	@Test
	void 자동차_목록을_생성한다() {
		String carNames = "test1,test2,test3";
		Cars cars = new Cars(carNames);
		assertThat(cars.carsNumber()).isEqualTo(CARS_COUNT);
	}

	@Test
	void 자동차를_리스트에_추가() {
		String carName = "test";
		Car car = new Car(carName, DEFAULT_POSITION);
		Cars cars = new Cars();
		cars.addCar(car);
		assertThat(cars.getCars()).isNotEmpty();
	}
}
