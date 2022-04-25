package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Race;

public class RaceTest {
	@Test
	public void createCarsTest() {
		List<Car> carList = new ArrayList<>();
		carList.add(new Car("apple"));
		carList.add(new Car("rang"));
		carList.add(new Car("banana"));
		Race race = new Race(carList);

	}

	@Test
	public void getWinner() {
		Map<String, Integer> map = new HashMap<>();
		map.put("apple", 2);
		map.put("orange", 3);
		map.put("banana", 3);

		int maxValue = Collections.max(map.values());
		ArrayList<String> winnerList = new ArrayList<>();
		for (Map.Entry<String, Integer> m : map.entrySet()) {
			if (m.getValue() == maxValue) {
				winnerList.add(m.getKey());
			}
		}
		System.out.println(String.join(", ", winnerList));
	}
}
