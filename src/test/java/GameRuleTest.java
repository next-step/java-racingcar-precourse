import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameRuleTest {

	private Car car1 = new Car("car1");
	private Car car2 = new Car("car2");
	private Car car3 = new Car("car3");
	private Car car4 = new Car("car4");
	private Car car5 = new Car("car5");
	private List<Car> cars = new ArrayList<>();
	private GameRule gameRule = new GameRule();

	@BeforeEach
	void setUp() {
		car1.go();

		car2.go();
		car2.go();

		car3.go();
		car3.go();

		cars = Arrays.asList(car1, car2, car3, car4, car5);
	}

	@Test
	void Car리스트에서_가장_큰_location_구하기() {
		int largestLocation = gameRule.getWinnerLocation(cars);
		assertThat(largestLocation).isEqualTo(2);
	}

	@Test
	void 가장_많이_이동한_자동차_구하기() {
		List<Car> winners = Arrays.asList(car2, car3);
		assertThat(gameRule.getWinners(cars, gameRule.getWinnerLocation(cars))).isEqualTo(winners);
	}

	@Test
	void 전진할지_스톱할지_판단() {
		int gameNumber1 = 4;
		int gameNumber2 = 3;
		assertThat(gameRule.isGoForward(gameNumber1)).isTrue();
		assertThat(gameRule.isGoForward(gameNumber2)).isFalse();
	}
}
