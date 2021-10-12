package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racinggame.functional.ForwardMoveRule;

class WinnerTest {
	@Test
	@DisplayName("우승자를 반환한다.")
	void getNames() {
		// given
		ForwardMoveRule alwaysForwardMove = ForwardMoveRule.alwaysForwardMove();
		Car gmoon = new Car("gmoon").moveOrStop(alwaysForwardMove);
		Car guest = new Car("guest").moveOrStop(alwaysForwardMove);
		Car kim = new Car("kim");
		Cars cars = new Cars(Arrays.asList(gmoon, guest, kim));

		// when
		Winner winner = new Winner(cars);

		// then
		assertThat(winner.getNames())
			.isEqualTo("gmoon,guest");
	}
}