package racing.game.domain.car;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

	private static Cars cars;

	@BeforeAll
	static void setUp() {
		cars = new Cars();
		cars.add(new Car("car1"));
		cars.add(new Car("car2"));
		cars.add(new Car("car3"));
		cars.add(new Car("car4"));

	}

	@Test
	@DisplayName("자동차마다 상태를 표시한다.")
	public void showLabStatus() {
		assertThat(cars.size()).isEqualTo(4);
		cars.runLab();
		cars.showLabStatus();
	}

	@Test
	@DisplayName("우승차량을 뽑아낸다.")
	public void getWinnerPoistion() {
		List<Car> winnerCars = cars.getWinnerCars();
	}
}