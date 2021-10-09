package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racinggame.functional.ForwardMoveRule;

class RoundTest {
	Round round;

	@BeforeEach
	void setUp() {
		round = new Round(Arrays.asList(new Car("gmoon"), new Car("guest")));
	}

	@Test
	@DisplayName("경주에 참여한 자동차들을 생성한다.")
	void create() {
		// then
		assertThat(round)
			.isEqualTo(new Round(Arrays.asList(new Car("gmoon"), new Car("guest"))));
	}

	@Test
	@DisplayName("각 자동차들을 경주시킨다.")
	void raceCars() {
		// given
		ForwardMoveRule alwaysForwardMoveRule = ForwardMoveRule.alwaysForwardMove();

		// when
		Round round = this.round.raceCars(alwaysForwardMoveRule);

		// then
		Car movedCarOfMine = new Car("gmoon").move();
		Car movedCarOfGuest = new Car("guest").move();
		assertThat(round)
			.isEqualTo(new Round(Arrays.asList(movedCarOfMine, movedCarOfGuest)));

	}
}