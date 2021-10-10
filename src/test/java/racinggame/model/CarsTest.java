package racinggame.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

	@Test
	@DisplayName("자동차들을 생성한다.")
	public void createCars() {
		Cars cars = new Cars(Arrays.asList(new Car("aaa"), new Car("bbb")));

		assertThat(cars).isEqualTo(new Cars(Arrays.asList(new Car("aaa"), new Car("bbb"))));
	}

	@Test
	@DisplayName("자동차이름들은 , 구분자로 분리된다. ")
	public void toSplit() {
		assertAll(
			() -> {
				Cars cars = new Cars("aa,bb,cc");
				assertThat(cars).isEqualTo(new Cars(getCars("aa", "bb", "cc")));
			},
			() -> {
				Cars cars = new Cars("aa,bb");
				assertThat(cars).isEqualTo(new Cars(getCars("aa", "bb")));
			},
			() -> {
				Cars cars = new Cars("aa.bb");
				assertThat(cars).isEqualTo(new Cars(getCars("aa.bb")));
			},
			() -> {
				Cars cars = new Cars("aa:bb,cc");
				assertThat(cars).isEqualTo(new Cars(getCars("aa:bb", "cc")));
			}
		);
	}

	private List<Car> getCars(String... names) {
		List<Car> cars = new ArrayList<>();
		for (String name : names) {
			cars.add(new Car(name));
		}
		return cars;
	}

	@Test
	@DisplayName("자동차들의 이름이 중복되면 예외가 발생한다.")
	public void checkDuplication() {
		assertThrows(IllegalArgumentException.class,
			() -> new Cars("aaa,aaa,bbb"));
	}

	@Test
	@DisplayName("레이싱의 최고 이동거리를 알수 있다.")
	public void maxDistance() {
		Cars cars = new Cars(getCars());

		assertThat(cars.maxDistance()).isEqualTo(3);
	}

	@Test
	@DisplayName("레이싱의 최고이동거리를 가진 자동차를 알 수 있다.")
	public void findWinnerCars() {
		Cars cars = new Cars(getCars());

		assertThat(cars.findWinnerCars()).containsExactly(new Car("aaa", 3));
	}

	private List<Car> getCars() {
		List<Car> cars = new ArrayList<>();
		cars.add(new Car("aaa", 3));
		cars.add(new Car("bbb", 2));
		cars.add(new Car("ccc", 1));
		return cars;
	}
}