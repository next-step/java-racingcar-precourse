package racinggame;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class CarsTest {

	@Test
	void 자동차들의_이름을_부여한_목록을_보유한다() {
		CarNames carNames = makeCarNamesOf("carA", "carB", "carC");
		Cars cars = new Cars(carNames);

		assertThat(cars.size()).isEqualTo(3);
	}

	@Test
	void 우승자동차를_부른다() {
		CarNames carNames = makeCarNamesOf("carA", "carB", "carC");
		Cars cars = new Cars(carNames);
		cars.race();
		cars.race();

		CarNames winnerCars = cars.getWinnerNames();

		System.out.println(winnerCars);
	}

	private CarNames makeCarNamesOf(String... names) {
		List<CarName> carNameList = new ArrayList<>();
		for (String name : names) {
			carNameList.add(new CarName(name));
		}

		return new CarNames(carNameList);
	}
}
