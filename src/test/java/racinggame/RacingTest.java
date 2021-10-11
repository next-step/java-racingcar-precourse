package racinggame;

import static org.assertj.core.api.Assertions.*;
import static racinggame.common.ErrorMessage.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
			racing.add(new Car(name));
		}
	}

	@Test
	void 레이싱_참가() {
		int size = 7;

		racing.add(new Car("wow"));

		assertThat(racing.getCarList())
			.hasSize(size);
	}

	@ParameterizedTest(name = "전진여부_판단 {index}")
	@ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
	void 전진여부_판단(int value) {
		boolean result = value >= Racing.GO_VALUE;
		assertThat(racing.isGo(value)).isEqualTo(result);
	}

	@Test
	void 전진여부_예외() {
		int minus = -1;
		assertThatThrownBy(() -> racing.isGo(minus))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(ERROR_GO_INPUT);
		int over = 11;
		assertThatThrownBy(() -> racing.isGo(over))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(ERROR_GO_INPUT);
	}

	@Test
	void 자동차_레이스() {
		List<Integer> list = Arrays.asList(1, 4, 5, 9, 3, 7);
		int goCnt = 4;
		String distance = "----";
		Car car = racing.getCarList().get(0);

		for (int i : list) {
			racing.race(car, i);
		}

		assertThat(car)
			.extracting("distance")
			.isEqualTo(goCnt);
		assertThat(car)
			.asString()
			.containsSequence(distance);
	}

	@Test
	void 제일_멀리간_거리_조회() {
		goCarListOrdering(racing.getCarList());
		int maxDistance = 2;

		int result = racing.getMaxDistance();

		assertThat(result)
			.isEqualTo(maxDistance);
	}

	@Test
	void 가장멀리간_자동차인경우_승리자_추가() {
		List<Car> carList = racing.getCarList();
		goCarListOrdering(racing.getCarList());
		int maxDistance = 2;

		Car car = carList.get(carList.size() - 1);
		racing.addWinnerList(maxDistance, car);

		assertThat(racing.getWinnerList())
			.hasSize(1)
			.containsExactly(car.getName());

	}

	@Test
	void 자동차_승자() {
		goCarListOrdering(racing.getCarList());
		String winnerStr = "논,진";

		String result = racing.getWinner();

		assertThat(result)
			.isNotEmpty()
			.isEqualTo(winnerStr);
	}

	@Test
	void 레이싱_결과출력() {
		goCarListOrdering(racing.getCarList());

		String result = racing.getRacingResultStr();

		assertThat(result)
			.isNotEmpty()
			.contains(":")
			.endsWith("\n");
	}

	@Test
	void 레이싱_진행오류() {
		Racing racing = new Racing();

		assertThatThrownBy(() -> racing.startRacing())
			.isInstanceOf(IllegalStateException.class)
			.hasMessage(ERROR_NO_CARS);
	}

}
