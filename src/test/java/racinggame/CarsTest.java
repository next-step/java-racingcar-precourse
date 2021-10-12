package racinggame;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import nextstep.utils.Randoms;

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

	@Test
	@DisplayName("각 자동차 play 기능")
	void playCars() {
		try (MockedStatic<Randoms> mockedStatic = mockStatic(Randoms.class)) {
			mockedStatic.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(3, 0, 6);

			cars = Cars.createByNames("pobi,crong,honux");
			cars.play();
			assertThat(cars.get(0).getPosition()).isEqualTo(0);
			assertThat(cars.get(1).getPosition()).isEqualTo(0);
			assertThat(cars.get(2).getPosition()).isEqualTo(1);
		}
	}

	@Test
	@DisplayName("우승자 구하기")
	void getWinners() {
		try (MockedStatic<Randoms> mockedStatic = mockStatic(Randoms.class)) {
			mockedStatic.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(3, 0, 6);

			cars = Cars.createByNames("pobi,crong,honux");
			cars.play();

			assertThat(cars.getWinners()).isEqualTo(Collections.singletonList(cars.get(2)));
		}
	}
}
