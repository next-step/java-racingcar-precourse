package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnersTest {
	private static final MoveStrategy FORWARD = () -> true;
	private static final MoveStrategy STOP = () -> false;

	@DisplayName("우승자를 출력한다")
	@Test
	void createTest() {
		Car car1 = Car.of("gunan");
		Car car2 = Car.of("k");
		Car car3 = Car.of("lee");
		car1.move(FORWARD);
		car1.move(STOP);
		car3.move(FORWARD);
		Winners winners = new WinnersFactory(Arrays.asList(car1, car2, car3)).getWinners();
		assertThat(winners.toString()).contains("gunan", "lee");
	}
}
