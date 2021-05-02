package racing.game.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StadiumTest {

	static List<String> carNames;
	static Stadium stadium;

	@BeforeAll
	public static void setUp() {
		carNames = Arrays.asList("벤츠", "bmw", "HYUNDAI", "KIA");
		stadium = new Stadium(carNames);

		stadium.setLapCount(10);
		stadium.startLap();
	}

	@Test
	@DisplayName("이름을 전달 받아 Cars 객체를 생성한다.")
	public void initCars() {
		assertThat(stadium.size()).isEqualTo(carNames.size());
	}

	@Test
	@DisplayName("우승자를 뽑는다.")
	public void getWinner() {
		stadium.chooseWinnerCars();
		stadium.showWinnerCar();
	}

}