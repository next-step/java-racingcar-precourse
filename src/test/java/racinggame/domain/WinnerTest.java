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
		Car gmoon = Car.createNew("gmoon").moveOrStop(alwaysForwardMove);
		Car guest = Car.createNew("guest").moveOrStop(alwaysForwardMove);
		Car kim = Car.createNew("kim");

		// when
		Winner winner = Winner.createNew(Arrays.asList(gmoon, guest, kim));

		// then
		assertThat(winner.getNames())
			.isEqualTo("gmoon,guest");
	}
}