package racinggame;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {
	private Cars cars;

	@Test
	@DisplayName("자동차가 없을 때")
	void emptyCars() {
		cars = new Cars(Collections.emptyList());
		assertThat(cars.isEmpty()).isTrue();
	}

	@Test
	@DisplayName("자동차 한대 추가하기")
	void addCar() {
		cars = new Cars(new Car("pobi"));
		assertThat(cars.isEmpty()).isFalse();
	}

	@Test
	@DisplayName("자동차 여러대 추가하기")
	void addCars() {
		cars = new Cars(Arrays.asList(new Car("pobi"), new Car("crong")));
		assertThat(cars.isEmpty()).isFalse();
	}

	@Test
	@DisplayName("이름 문자열에서 여러대 추가하기")
	void addCarsFromString() {
		String names = "pobi,crong";
		cars = Cars.createByNames(names);
		assertThat(cars.isEmpty()).isFalse();
	}
}
