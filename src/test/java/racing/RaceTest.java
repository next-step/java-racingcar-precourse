package racing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceTest {
	private List<String> carNameStrings;
	private int tryCount;

	private Race race;

	@BeforeEach
	void init() {
		this.carNameStrings = Arrays.asList("pobi", "crong", "honux");
		this.tryCount = 5;

		this.race = new Race(String.join(",", this.carNameStrings), this.tryCount);
	}

	@DisplayName("사용자의 입력값을 자동차들과 라운드로 변환한다.")
	@Test
	void 사용자의_입력값을_자동차들과_라운드로_변환한다() {
		List<Car> cars = this.race.getCars();
		Round round = this.race.getRound();
		List<String> carNameStrings = new ArrayList<>();
		for (Car car : cars) {
			CarName carName = car.getCarName();
			carNameStrings.add(carName.getName());
		}

		assertTrue(carNameStrings.containsAll(this.carNameStrings));
		assertEquals(tryCount, round.getVal());
	}
}
