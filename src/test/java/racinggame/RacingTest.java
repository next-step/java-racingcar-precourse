package racinggame;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racinggame.domain.Car;
import racinggame.domain.Racing;

public class RacingTest {

	Racing racing;

	public static void goCarListOrdering(List<Car> carList) {
		for (int i = 0; i < carList.size(); i++) {
			goCar(carList.get(i), i / 2);
		}
	}

	public static void goCar(Car car, int goCount) {
		for (int i = 0; i < goCount; i++) {
			car.go();
		}
	}

	@BeforeEach
	void setUp() {
		racing = new Racing();
		List<String> names = Arrays.asList("Lee", "Park", "Kim", "제이", "논", "진");
		for (String name : names) {
			racing.join(new Car(name));
		}
	}

	@Test
	void 레이싱_참가() {
		int size = 7;

		racing.join(new Car("wow"));

		assertThat(racing.getCars().getCarList())
			.hasSize(size);
	}

}
